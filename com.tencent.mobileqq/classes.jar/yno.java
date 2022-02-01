import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class yno
  extends ynu
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected ywf a;
  
  public yno(@NonNull ynw paramynw)
  {
    super(paramynw);
  }
  
  private void g()
  {
    i();
    if (this.jdField_a_of_type_Ywf.a() != 0)
    {
      this.jdField_a_of_type_Ywf.a(0);
      this.jdField_a_of_type_Ywf.a.requestFocus();
      bkxz.a(this.jdField_a_of_type_Ywf.a);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Ywf != null) && (this.jdField_a_of_type_Ywf.a() == 0))
    {
      this.jdField_a_of_type_Ywf.a(4);
      bkxz.b(this.jdField_a_of_type_Ywf.a);
      this.jdField_a_of_type_Ywf.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Ywf == null)
    {
      this.jdField_a_of_type_Ywf = new ywf(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Ywf.a(new ynq(this));
      this.jdField_a_of_type_Ywf.b(new ynr(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362183));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new ynp(this));
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
  
  public void a(int paramInt, @NonNull yya paramyya)
  {
    super.a(paramInt, paramyya);
    paramyya.a.videoLabel = a();
    ynw localynw;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localynw = this.jdField_a_of_type_Ynw;
        str = a();
        if (!this.jdField_a_of_type_Ynw.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramyya = "2";; paramyya = "1")
    {
      localynw.a("pub_tag", 0, 0, new String[] { "1", str, paramyya });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Ywf != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Ywf.a() == 0)
      {
        this.jdField_a_of_type_Ynw.a(0);
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
 * Qualified Name:     yno
 * JD-Core Version:    0.7.0.1
 */