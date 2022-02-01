import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class afgi
  implements afgt.a
{
  afgi(afgf paramafgf, ajlm paramajlm) {}
  
  public void Mr(int paramInt)
  {
    this.b.Rg(paramInt);
  }
  
  public void a(afge paramafge)
  {
    if ((paramafge != null) && (!this.c.d.isFinishing())) {
      switch (paramafge.result)
      {
      }
    }
    for (;;)
    {
      if (this.b.isShowing()) {
        this.b.dismiss();
      }
      afgf.a(this.c);
      afgf.a(this.c).a().cZp();
      return;
      QQToast.a(this.c.d.getApplicationContext(), this.c.d.getString(2131718933), 0).show();
      continue;
      if (paramafge.errorCode == 10006)
      {
        QQToast.a(this.c.d.getApplicationContext(), this.c.d.getString(2131718924), 0).show();
      }
      else
      {
        QQToast.a(this.c.d.getApplicationContext(), this.c.d.getString(2131718928), 0).show();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("MultiEmotionSaveManager", 2, "onSaveComplete " + this.c.d.isFinishing());
        }
      }
    }
  }
  
  public void bKd()
  {
    if (!this.b.isShowing())
    {
      this.b.Rg(0);
      this.b.a(new afgj(this));
      if (QLog.isColorLevel()) {
        QLog.i("MultiEmotionSaveManager", 2, "onSaveBegin");
      }
      this.b.show();
    }
  }
  
  public void bKe()
  {
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
    afgf.a(this.c);
    afgf.a(this.c).a().cZp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afgi
 * JD-Core Version:    0.7.0.1
 */