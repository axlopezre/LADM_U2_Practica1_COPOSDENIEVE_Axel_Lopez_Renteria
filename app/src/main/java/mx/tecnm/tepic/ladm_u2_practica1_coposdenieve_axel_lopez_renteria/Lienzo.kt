package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_axel_lopez_renteria

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.random.Random


class Lienzo (este: MainActivity) : View(este) {
    var este = este
    var LasY = 200f
    var conta = 0
    var cc=(0..1).random()
    var Copos = Array<MovCopo>((60..100).random(), { MovCopo(this@Lienzo) })//Nevada lenta
    var Copos2 = Array<MovCopo>((10..25).random(), { MovCopo(this@Lienzo) })//Nevada lenta
    fun rutina2dPlanoAsincrona() = GlobalScope.launch {
        //Ejecución en segundo plano
        este.runOnUiThread {

            if(conta<=250) {
                for (contador in 0..Copos.size - 1) {
                    if (Copos[contador].LasY <= 1800f) {
                        if (Copos[contador].radio < 15) {
                            Copos[contador].LasY += Copos[contador].random2 - 16
                        } else {
                            Copos[contador].LasY += Copos[contador].random2
                        }
                    } else {
                        Copos[contador].LasY = 20f
                    }
                }
                conta++

            }else{
                for (contador in 0..Copos2.size - 1) {
                    if (Copos2[contador].LasY <= 1800f) {
                        if (Copos2[contador].radio < 15) {
                            Copos2[contador].LasY += Copos2[contador].random - 16
                          //  Copos2[contador].LasX += 3
                        } else {
                            Copos2[contador].LasY += Copos2[contador].random
                           // Copos2[contador].LasX += 5
                        }
                    } else {
                        Copos2[contador].LasY = 20f
                    }
                }
                conta++
                if(conta==500) conta = 0
            }
            invalidate()
        }
        delay(5000L)

    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        //Color Fondo
        val color = Color.rgb(3, 41, 43)
        c.drawColor(color)

        //Cuadrado de la casa
        p.setColor(Color.parseColor("#8D4925"));
        p.style = Paint.Style.FILL
        p.strokeWidth = 20f
        c.drawRect(400f, 850f, 940f, 1200f, p)

        //Triangulo de la casa
        val path = Path()
        p.color = Color.YELLOW
        path.moveTo(400f, 830f)
        path.lineTo(670f, 500f)
        path.lineTo(950f, 830f)
        p.style = Paint.Style.FILL
        c.drawPath(path, p)

        //Ventana central
        p.color = Color.BLUE
        c.drawCircle(670f, 730f, 70f, p)

        //LineaCentral
        p.strokeWidth = 23f
        p.setColor(Color.parseColor("#97DCD8C6"))
        c.drawLine(410f, 930f, 940f, 930f, p)

        //PUERTA
        c.drawRect(600f, 970f, 750f, 1200f, p)

        p.color = Color.BLACK
        c.drawCircle(720f, 1120f, 15f, p)

        //CARRETERA
        p.setColor(Color.parseColor("#5564eb"));
        p.style = Paint.Style.FILL
        c.drawRect(10f, 1700f, 1100f, 1300f, p)

        //NIEVE CARRETERA
        p.color = Color.WHITE
        p.strokeWidth = 30f
        c.drawLine(10f, 1300f, 1100f, 1300f, p)

        //NIEVE CARRETERA 2
        p.color = Color.WHITE
        c.drawLine(10f, 1700f, 1100f, 1700f, p)

        //FARO
        p.setColor(Color.parseColor("#FF673AB7"));
        c.drawLine(1020f, 1200f, 1020f, 850f, p)
        c.drawLine(980f, 1200f, 1050f, 1200f, p)
        p.color = Color.YELLOW
        c.drawCircle(1020f, 850f, 40f, p)

        //NUBES
        p.setColor(Color.parseColor("#FC164D6A"));
        p.style = Paint.Style.FILL
        c.drawCircle(140f, 160f, 70f, p)
        c.drawCircle(240f, 160f, 70f, p)
        c.drawCircle(140f, 200f, 70f, p)
        c.drawCircle(240f, 200f, 70f, p)

        c.drawCircle(90f, 180f, 50f, p)
        c.drawCircle(380f, 180f, 50f, p)

        c.drawCircle(240f, 160f, 70f, p)
        c.drawCircle(340f, 160f, 70f, p)
        c.drawCircle(240f, 200f, 70f, p)
        c.drawCircle(340f, 200f, 70f, p)

        c.drawCircle(640f, 160f, 70f, p)
        c.drawCircle(740f, 160f, 70f, p)
        c.drawCircle(640f, 200f, 70f, p)
        c.drawCircle(740f, 200f, 70f, p)

        c.drawCircle(590f, 180f, 50f, p)
        c.drawCircle(880f, 180f, 50f, p)

        c.drawCircle(740f, 160f, 70f, p)
        c.drawCircle(840f, 160f, 70f, p)
        c.drawCircle(740f, 200f, 70f, p)
        c.drawCircle(840f, 200f, 70f, p)

        //CHIMENEA
        p.color = Color.WHITE
        c.drawLine(500f, 710f, 500f, 500f, p)
        c.drawOval(500f, 550f, 400f, 470f, p)

        //ARBOL DE NAVIDAD
        p.setColor(Color.parseColor("#8D4925"))
        c.drawLine(140f, 1200f, 140f, 1000f, p)


        val pathx = Path()
        p.color = Color.GREEN
        pathx.moveTo(140f, 800f)
        pathx.lineTo(240f, 1000f)
        pathx.lineTo(50f, 1000f)
        p.style = Paint.Style.FILL
        c.drawPath(pathx, p)

        pathx.moveTo(140f, 700f)
        pathx.lineTo(230f, 900f)
        pathx.lineTo(60f, 900f)
        p.style = Paint.Style.FILL
        c.drawPath(pathx, p)

        pathx.moveTo(140f, 600f)
        pathx.lineTo(220f, 800f)
        pathx.lineTo(70f, 800f)
        p.style = Paint.Style.FILL
        c.drawPath(pathx, p)

        pathx.moveTo(140f, 500f)
        pathx.lineTo(210f, 700f)
        pathx.lineTo(80f, 700f)
        p.style = Paint.Style.FILL
        c.drawPath(pathx, p)

        p.color = Color.RED
        c.drawCircle(100f, 950f, 20f, p)

        p.color = Color.YELLOW
        c.drawCircle(170f, 900f, 20f, p)

        p.color = Color.BLUE
        c.drawCircle(150f, 800f, 20f, p)

        p.color = Color.GRAY
        c.drawCircle(130f, 700f, 20f, p)

        p.color = Color.RED
        c.drawCircle(160f, 630f, 20f, p)

        if(conta<=250) {
            (0..Copos.size - 1).forEach {
                p.color = Copos[it].elcolor
                c.drawCircle(Copos[it].LasX, Copos[it].LasY, Copos[it].radio, p)
            }
        }else {
            (0..Copos2.size - 1).forEach {
                p.color = Copos2[it].elcolor
                c.drawCircle(Copos2[it].LasX, Copos2[it].LasY, Copos2[it].radio, p)
            }

        }
        rutina2dPlanoAsincrona()
        //invalidate()
    }
}
class MovCopo(Li: Lienzo) {
    var conta2 = 0
    var LasX = (40..1000).random().toFloat()
    var random = (20..30).random().toFloat()
    var random2 = (40..60).random().toFloat()
    var LasY = (300..1000).random().toFloat()
    var radio = (5..30).random().toFloat()
    var elcolor = Color.WHITE
}
