import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class xyv
  extends xzb
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected yhm a;
  
  public xyv(@NonNull xzd paramxzd)
  {
    super(paramxzd);
  }
  
  private void g()
  {
    i();
    if (this.jdField_a_of_type_Yhm.a() != 0)
    {
      this.jdField_a_of_type_Yhm.a(0);
      this.jdField_a_of_type_Yhm.a.requestFocus();
      bjmm.a(this.jdField_a_of_type_Yhm.a);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Yhm != null) && (this.jdField_a_of_type_Yhm.a() == 0))
    {
      this.jdField_a_of_type_Yhm.a(4);
      bjmm.b(this.jdField_a_of_type_Yhm.a);
      this.jdField_a_of_type_Yhm.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Yhm == null)
    {
      this.jdField_a_of_type_Yhm = new yhm(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Yhm.a(new xyx(this));
      this.jdField_a_of_type_Yhm.b(new xyy(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362180));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new xyw(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      h();
      return;
    case 0: 
      h();
      return;
    }
    g();
  }
  
  public void a(int paramInt, @NonNull yjh paramyjh)
  {
    super.a(paramInt, paramyjh);
    paramyjh.a.videoLabel = a();
    xzd localxzd;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localxzd = this.jdField_a_of_type_Xzd;
        str = a();
        if (!this.jdField_a_of_type_Xzd.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramyjh = "2";; paramyjh = "1")
    {
      localxzd.a("pub_tag", 0, 0, new String[] { "1", str, paramyjh });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Yhm != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Yhm.a() == 0)
      {
        this.jdField_a_of_type_Xzd.a(0);
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
 * Qualified Name:     xyv
 * JD-Core Version:    0.7.0.1
 */