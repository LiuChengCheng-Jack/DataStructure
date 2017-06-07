function Calculators(express){
      this.express=express;
      function changeExp(e){
           this.express=e;
      }
}
Calculators.prototype.calculate=calculate;

function calculate() {
	var midExpression=this.express;
             // alert(midExpression);
	var stack = [];
	var operatorStack=[];
	var numberStack=[];
	operatorStack.push('#');
	var flag = false; // 标记是否为一个数结束
	for (var i = 0; i < midExpression.length; i++) {
		var e = midExpression.charAt(i);

		if (isNumber(e)) {

			var s=e+'';
			stack.push(parseInt(s));
			flag = true;
		} else {
			var exp = 1;
			var num = 0;

			if (flag) {
				while (stack.length!=0) {
					num += stack.pop() * exp;
					exp = exp * 10;
				}
				numberStack.push(num * 1.0);

				if (!stack.length==0) {
					stack=[];
				}
				flag = false;
			}

			var stackTop = operatorStack[operatorStack.length-1];
			var result = precedence(e, stackTop);

			switch (result) {
				case '>':
					operatorStack.push(e);
					break;
				case '<':
					var num1 = numberStack.pop();
					var num2 = numberStack.pop();
					var op = operatorStack.pop();
					var resultT = getResult(num2, num1, op);
					numberStack.push(resultT);
					i--; // 继续停留
					break;
				case '=':
					operatorStack.pop();
					break;
				default:
					break;
			}
		}
	}
	
	if (!numberStack.length==0) {
		return numberStack.pop();
	}
	else {
		return 0;
	}

}

function getResult(n1,  n2, op) {
	var result = 0.0;
	switch (op) {
		case '+':
			result = n1 + n2;
			break;
		case '-':
			result = n1 - n2;
			break;
		case '*':
			result = n1 * n2;
			break;
		case '/':
			result = n1 / n2;
			break;
		default:
			break;
	}
	return result;
}

function isNumber(e) {
	var is = false;
	switch (e) {
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			is = true;
			break;
		default:
			break;
	}
	return is;
}

// 比较两个函数的优先级,若op1优先级高(低)，输出'>(<)',相等则为'='
// op1代表栈外元素符，op2代表栈内运算符
function precedence(op1, op2) {
	var num1 = getStackInOut(op1, 1);
	var num2 = getStackInOut(op2, 0);
	var back = '=';
	if (num1 > num2) {
		back = '>';
	} else if (num1 < num2) {
		back = '<';
	} else {
		back = '=';
	}
	return back;
}

/*
 * flag=0 代表为in,flag=1代表为out
 */
function getStackInOut(op,flag) {
	var back = -1;
	if (flag == 0) {
		switch (op) {
			case '#':
				back = 0;
				break;
			case '(':
				back = 1;
				break;
			case '^':
				back = 7;
				break;
			case '*':
			case '/':
			case '%':
				back = 5;
				break;
			case '+':
			case '-':
				back = 3;
				break;
			case ')':
				back = 8;
				break;
			default:
				break;
		}
	} else {
		switch (op) {
			case '#':
				back = 0;
				break;
			case '(':
				back = 8;
				break;
			case '^':
				back = 6;
				break;
			case '*':
			case '/':
			case '%':
				back = 4;
				break;
			case '+':
			case '-':
				back = 2;
				break;
			case ')':
				back = 1;
				break;
			default:
				break;
		}
	}
	return back;
}

