import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class ytp
  extends ytw
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected zcr a;
  
  public ytp(@NonNull yty paramyty)
  {
    super(paramyty);
  }
  
  private void f()
  {
    i();
    if (this.jdField_a_of_type_Zcr.a() != 0)
    {
      this.jdField_a_of_type_Zcr.a(0);
      this.jdField_a_of_type_Zcr.a.requestFocus();
      bkft.a(this.jdField_a_of_type_Zcr.a);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Zcr != null) && (this.jdField_a_of_type_Zcr.a() == 0))
    {
      this.jdField_a_of_type_Zcr.a(4);
      bkft.b(this.jdField_a_of_type_Zcr.a);
      this.jdField_a_of_type_Zcr.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Zcr == null)
    {
      this.jdField_a_of_type_Zcr = new zcr(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Zcr.a(new ytr(this));
      this.jdField_a_of_type_Zcr.b(new yts(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362174));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new ytq(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      g();
      return;
    case 0: 
      g();
      return;
    }
    f();
  }
  
  public void a(int paramInt, @NonNull zem paramzem)
  {
    super.a(paramInt, paramzem);
    paramzem.a.videoLabel = a();
    yty localyty;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localyty = this.jdField_a_of_type_Yty;
        str = a();
        if (!this.jdField_a_of_type_Yty.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramzem = "2";; paramzem = "1")
    {
      localyty.a("pub_tag", 0, 0, new String[] { "1", str, paramzem });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Zcr != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Zcr.a() == 0)
      {
        this.jdField_a_of_type_Yty.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytp
 * JD-Core Version:    0.7.0.1
 */