package mx.programacionavanzada.examen1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.text.toFloat

class MainActivity : AppCompatActivity() {


    /**
     * Creamos una variable de tipo TextView que accederá al componente tv_text de nuestro layout.
     * Este TextView mostrará el display de nuestra calculadora
     */

    var texto : TextView? = null

    var valor1 : Float = 0F
    var valor2 : Float = 0F
    var LastOperador : Char ? = null
    var EstaEnOperacion : Boolean = false
    var LimpiaDisplay : Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Le asignamos a nuestra variable el TextView con identificador tv_text
        texto = findViewById<TextView>(R.id.tv_text)


        //TODO Realizar una función para el evento OnClickListener para el botón "CLEAR" que al presionar estableza el display en 0


        //TODO Realizar una función para el evento OnClickListener para el botón "+/-" que al presionar cambie valore de negativos a positivos siempre que sea diferente a 0 (0.00, 0.00 etc)


        //TODO Realizar una función para el evento OnClickListener para el botón "/"
        val btn_divide = findViewById<Button>(R.id.btn_divide)
        btn_divide.setOnClickListener({ View -> btn_operacionesListener('/')})
        //TODO Realizar una función para el evento OnClickListener para el botón "*"
        val btn_multiplication = findViewById<Button>(R.id.btn_multiplication)
        btn_multiplication.setOnClickListener({View -> btn_operacionesListener('*')})

        val btn_plus = findViewById<Button>(R.id.btn_plus)
        btn_plus.setOnClickListener({ View -> btn_operacionesListener('+')})

        val btn_minus = findViewById<Button>(R.id.btn_minus)
        btn_minus.setOnClickListener({ View -> btn_operacionesListener('-')})

        //TODO Realizar una función para el evento OnClickListener para el botón "."
        val btn_dot = findViewById<Button>(R.id.btn_dot)
        btn_dot.setOnClickListener ({ View -> btn_operacionesListener( '.') })

        //TODO Realizar una función para el evento OnClickListener para el botón "="
        val btn_equal = findViewById<Button>(R.id.btn_equal)
        btn_equal.setOnClickListener({View -> btn_operacionesListener('=')})

        //TODO Realizar una función para el evento OnClickListener para el botón del número 0
        val btn_zero = findViewById<Button>(R.id.btn_zero)
        btn_zero.setOnClickListener({View -> btn_numerosListener('0')})

        val btn_one = findViewById<Button>(R.id.btn_one)
        btn_one.setOnClickListener({ View -> btn_numerosListener("1")})

        //TODO Realizar una función para el evento OnClickListener para el botón del número 2
        val btn_two = findViewById<Button>(R.id.btn_two)
        btn_two.setOnClickListener({ View -> btn_numerosListener("2")})

        //TODO Realizar una función para el evento OnClickListener para el botón del número 3
        val btn_three = findViewById<Button>(R.id.btn_three)
        btn_three.setOnClickListener({View -> btn_numerosListener("3")})

        //TODO Realizar una función para el evento OnClickListener para el botón del número 4
        val btn_four = findViewById<Button>(R.id.btn_four)
        btn_four.setOnClickListener { View -> btn_numerosListener("4") }
        //TODO Realizar una función para el evento OnClickListener para el botón del número 5
        val btn_five = findViewById<Button>(R.id.btn_five)
        btn_five.setOnClickListener { View -> btn_numerosListener("5") }

        //TODO Realizar una función para el evento OnClickListener para el botón del número 6
        val btn_six = findViewById<Button>(R.id.btn_six)
        btn_six.setOnClickListener({View -> btn_numerosListener("6")})
        //TODO Realizar una función para el evento OnClickListener para el botón del número 7
        val btn_seven = findViewById<Button>(R.id.btn_seven)
        btn_seven.setOnClickListener ({ View -> btn_numerosListener("7") })

        //TODO Realizar una función para el evento OnClickListener para el botón del número 8
        val btn_eight = findViewById<Button>(R.id.btn_eight)
        btn_eight.setOnClickListener ({View -> btn_numerosListener("8")})

        //Función para el evento OnClickListener para el botón del número 9
        val btn_nine = findViewById<Button>(R.id.btn_nine)
        btn_nine.setOnClickListener({ View -> btn_numerosListener("9")})
    }


    /**
     * Función para registrar los números
     * Posiblemente no tengas que cambiar nada en esta función
     */
    fun btn_numerosListener(numero:String) {
        if(texto!!.text.equals("0")) {
            texto!!.text = numero
        }
        else {

            if(LimpiaDisplay) {
                texto!!.text = numero
                LimpiaDisplay = false
            }
            else  {
                texto!!.text = texto!!.text.toString() + numero
            }
        }
    }

    /**
     * Función para almacenar los valores de la última operación
     * Posiblemente no tengas que cambiar nada en esta función
     */
    fun btn_operacionesListener(operador:Char) {
       if(EstaEnOperacion) {
           valor2 = texto!!.text.toString().toFloat()

           realizaOperaciones()
       }
        else {
           valor1 = texto!!.text.toString().toFloat()

       }
        LastOperador = operador
        EstaEnOperacion = true
        LimpiaDisplay = true
    }

    fun realizaOperaciones() {
        when (LastOperador) {
            '+' -> {
                valor1 = valor1 + valor2
                texto!!.text = valor1.toString()

                valor2 = 0F
            }
            '-' -> {
                valor1 = valor1 - valor2
                texto!!.text = valor1.toString()

                valor2 = 0F
            }
            //TODO Agregar operación para multiplicar
            '*'  ->{
                valor1 = valor1 * valor2
                texto!!.text = valor1.toString()

                valor2 = 0F
            }
        //TODO Agregar operación para dividir (cuidado con dividir sobre 0)
            '/' ->{
                valor1 = valor1 / valor2
                texto!!.text = valor1.toString()
                valor2 = 0F
            }

        }
    }




}
