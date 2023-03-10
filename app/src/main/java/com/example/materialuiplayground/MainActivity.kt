package com.example.materialuiplayground

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.materialuiplayground.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideCheckMarkIcon()
        setListenerForTextInputLayout()
        setListenerForCheckMarkIcon()
        preSelectDropdownOption()
        hideDropdownEndDrawable()
    }

    private fun hideDropdownEndDrawable() {
        binding.menu.endIconMode = TextInputLayout.END_ICON_NONE
    }

    private fun preSelectDropdownOption() {
        binding.apply {
            autoCompleteDropdown.setText("+91",false)
        }
    }

    private fun hideCheckMarkIcon() {
        binding.enterNumberBox.apply {
            isEndIconVisible = false
        }

    }


    private fun setListenerForCheckMarkIcon() {
        binding.apply {
            numberInputField.addTextChangedListener {
                binding.enterNumberBox.isEndIconVisible = it?.length==10
            }
        }
    }


    private fun setListenerForTextInputLayout() {
        binding.apply {
            numberInputField.apply {
                setOnFocusChangeListener { _, hasFocus ->
                    if(hasFocus){
                        enterNumberBox.hint = null
                    } else{
                        if(numberInputField.isEditTextEmpty()) {
                            enterNumberBox.hint = "9XXXXXXXXXX"
                        }
                    }
                }
            }

            nameInputField.setOnFocusChangeListener { _, hasFocus ->
                if(hasFocus){
                    enterNameBox.hint = null
                } else{
                    if(nameInputField.isEditTextEmpty()) {
                        enterNameBox.hint = "Naam Likh Bhai"
                    }
                }
            }

        }
    }
}


fun EditText.isEditTextEmpty() : Boolean{
    return this.text.toString().trim().isEmpty()
}