package com.android.s19110209;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    private Calculator mCalculator;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the calculator class and all the views
        mCalculator = new Calculator();
        mResultTextView = findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
    }

    private boolean isFull() {
        if (mOperandOneEditText.getText().toString().isEmpty() ||
                mOperandTwoEditText.getText().toString().isEmpty()) {
            return false;
        }
        return true;
    }

    public void onAdd(View view) {
        if (isFull()) {
            compute(Calculator.Operator.ADD);
        }
        else{
            Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSub(View view) {
        if (isFull()) {
            compute(Calculator.Operator.SUB);
        }
        else{
            Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void onDiv(View view) {
        try {
            if (isFull()) {
                compute(Calculator.Operator.DIV);
            }
            else{
                Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            }

        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText("error");
        }
    }

    public void onMul(View view) {
        if (isFull()) {
            compute(Calculator.Operator.MUL);
        }
        else{
            Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void onPow(View view) {
        try {
            if (isFull()) {
                compute(Calculator.Operator.POW);
            }
            else{
                Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            }

        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText("Error");
        }
    }

    public void onFact(View view) {
        try {
            if (isFull()) {
                compute(Calculator.Operator.FACT);
            }
            else{
                Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            }
        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText("Error");
        }
    }

    public void onLog(View view) {
        try {
            if (isFull()) {
                compute(Calculator.Operator.LOG);
            }
            else{
                Toast.makeText(this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            }

        } catch (IllegalArgumentException iae) {
            Log.e(TAG, "IllegalArgumentException", iae);
            mResultTextView.setText("Error");
        }
    }

    private void compute(Calculator.Operator operator) {
        double operandOne;
        double operandTwo;
        try {
            operandOne = getOperand(mOperandOneEditText);
            operandTwo = getOperand(mOperandTwoEditText);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            mResultTextView.setText("Error");
            return;
        }

        String result;
        switch (operator) {
            case ADD:
                result = String.valueOf(
                        mCalculator.add(operandOne, operandTwo));
                break;
            case SUB:
                result = String.valueOf(
                        mCalculator.sub(operandOne, operandTwo));
                break;
            case DIV:
                result = String.valueOf(
                        mCalculator.div(operandOne, operandTwo));
                break;
            case MUL:
                result = String.valueOf(
                        mCalculator.mul(operandOne, operandTwo));
                break;
            case POW:
                result = String.valueOf(
                        mCalculator.pow(operandOne, operandTwo));
                break;
            case FACT:
                result = String.valueOf(
                        mCalculator.fact(operandOne));
                break;
            case LOG:
                result = String.valueOf(
                        mCalculator.log(operandOne, operandTwo));
                break;
            default:
                result = "Error";
                break;
        }
        mResultTextView.setText(result);
    }

    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }
}