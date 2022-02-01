import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class agqn
  implements View.OnClickListener
{
  agqn(String paramString, agsa paramagsa) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        localagqo = new agqo(this);
        localagzy = agzy.a(this.bIW);
        if (localagzy != null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.w("FileOperaterUtils", 2, "error. get filemodel null, filepath[ " + this.bIW + "]");
        }
      }
      catch (Exception localException)
      {
        agqo localagqo;
        agzy localagzy;
        continue;
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (localagzy.bd(false))
      {
        if (!aqiw.bW(BaseApplicationImpl.getContext())) {
          ahao.OS(2131694663);
        } else if (armm.a(this.c.getActivity(), 5, new agqp(this, localagqo))) {
          ahal.a(this.c.getActivity(), 2131693826, 2131693830, localagqo);
        }
      }
      else {
        localagqo.aD();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqn
 * JD-Core Version:    0.7.0.1
 */