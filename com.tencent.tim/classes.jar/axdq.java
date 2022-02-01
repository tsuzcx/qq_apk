import android.support.annotation.Nullable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class axdq
  implements axzv<axdd>
{
  axdq(axdn paramaxdn) {}
  
  public void b(@Nullable axdd paramaxdd)
  {
    axdn.a(this.a).l().g(axdn.a(this.a));
    axdd localaxdd;
    if (paramaxdd != null)
    {
      localaxdd = paramaxdd;
      if (paramaxdd.cTN != null) {}
    }
    else
    {
      localaxdd = new axdd();
      localaxdd.cTN = "default";
    }
    paramaxdd = (String)axdn.a(this.a).get(localaxdd.cTN);
    if (!localaxdd.cTN.equals("default")) {
      paramaxdd = acfp.m(2131702159) + paramaxdd + acfp.m(2131702152);
    }
    for (;;)
    {
      axdn.a(this.a).setText(paramaxdd);
      if ((axdn.a(this.a).size() == 0) && (!axdn.a(this.a)))
      {
        axdn.a(this.a).addAll(localaxdd.Mu);
        this.a.eIY();
        axdn.a(this.a, true);
      }
      return;
      paramaxdd = acfp.m(2131702148);
      localaxdd.Mu.addAll(axdn.Mw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdq
 * JD-Core Version:    0.7.0.1
 */