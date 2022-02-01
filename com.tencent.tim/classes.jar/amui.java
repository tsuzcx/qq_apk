import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.search.rich.ArkAppView;
import com.tencent.qphone.base.util.QLog;

public class amui
  extends amur
  implements amuj
{
  private static amuc jdField_a_of_type_Amuc = new amuc();
  private amuf jdField_a_of_type_Amuf;
  private amue b;
  private int dDF = 0;
  
  public amui(amue paramamue)
  {
    this.b = paramamue;
    if ((this.b != null) && (QLog.isColorLevel())) {
      QLog.d("ArkRichNode", 2, "id:" + this.b.getID() + " appname:" + this.b.getAppName() + " viewname:" + this.b.zp() + " miniversion:" + this.b.getAppVersion() + " path：" + this.b.zo());
    }
  }
  
  public int Jb()
  {
    return this.dDF;
  }
  
  public void PW(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onSetTalkBackText:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    StringBuilder localStringBuilder;
    do
    {
      amum localamum;
      do
      {
        do
        {
          return;
          localamum = a();
        } while (localamum == null);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        paramString = localamum.getView();
        if (paramString != null) {
          paramString.setContentDescription(localStringBuilder);
        }
      } while (!(localamum instanceof amug));
      paramString = ((amug)localamum).cs();
    } while (!(paramString instanceof ArkAppView));
    ((ArkAppView)paramString).setContentDescription(localStringBuilder);
  }
  
  public void Pw(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Amuf != null) {
      this.jdField_a_of_type_Amuf.activateView(paramBoolean);
    }
  }
  
  public amuf a()
  {
    return this.jdField_a_of_type_Amuf;
  }
  
  public amum a(Context paramContext)
  {
    if (this.b == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRichNode", 2, "onCreate config = null");
      }
      return null;
    }
    amug localamug = new amug(this, paramContext);
    localamug.a(this);
    localamug.eQ(paramContext);
    jdField_a_of_type_Amuc.a(this);
    this.jdField_a_of_type_Amuf = new amuf(jdField_a_of_type_Amuc);
    String str = getData();
    this.jdField_a_of_type_Amuf.a(this.b, str, paramContext.getResources().getDisplayMetrics().scaledDensity);
    this.jdField_a_of_type_Amuf.setFixSize(-1, -1);
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Amuf.setMaxSize(i, -1);
    this.jdField_a_of_type_Amuf.setMinSize(i, -1);
    localamug.a(this.jdField_a_of_type_Amuf);
    this.jdField_a_of_type_Amuf.activateView(true);
    return localamug;
  }
  
  public void aT(String paramString1, String paramString2, String paramString3)
  {
    super.aT(paramString1, paramString2, paramString3);
    if (this.jdField_a_of_type_Amuf != null) {
      this.jdField_a_of_type_Amuf.updateMetaData(getData());
    }
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void hn(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onNotifyEvent, key:" + paramString1 + " value:" + paramString2);
    }
    ho(paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkRichNode", 2, "onDestroy");
    }
    if (jdField_a_of_type_Amuc != null) {
      jdField_a_of_type_Amuc.b(this);
    }
    if (this.jdField_a_of_type_Amuf != null)
    {
      this.jdField_a_of_type_Amuf.doOnEvent(2);
      this.jdField_a_of_type_Amuf.unInit();
      this.jdField_a_of_type_Amuf = null;
    }
    this.b = null;
  }
  
  public void onLoadResult(int paramInt)
  {
    this.dDF = paramInt;
    dOt();
  }
  
  public void pause()
  {
    super.pause();
    if (this.jdField_a_of_type_Amuf != null) {
      this.jdField_a_of_type_Amuf.doOnEvent(0);
    }
  }
  
  public void resume()
  {
    super.resume();
    if (this.jdField_a_of_type_Amuf != null) {
      this.jdField_a_of_type_Amuf.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amui
 * JD-Core Version:    0.7.0.1
 */