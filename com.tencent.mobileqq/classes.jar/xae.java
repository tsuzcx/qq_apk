import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.widget.XEditTextEx;

public class xae
  extends xal
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected String a;
  protected xjg a;
  
  public xae(@NonNull xan paramxan)
  {
    super(paramxan);
  }
  
  private void f()
  {
    i();
    if (this.jdField_a_of_type_Xjg.a() != 0)
    {
      this.jdField_a_of_type_Xjg.a(0);
      this.jdField_a_of_type_Xjg.a.requestFocus();
      bhsj.a(this.jdField_a_of_type_Xjg.a);
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Xjg != null) && (this.jdField_a_of_type_Xjg.a() == 0))
    {
      this.jdField_a_of_type_Xjg.a(4);
      bhsj.b(this.jdField_a_of_type_Xjg.a);
      this.jdField_a_of_type_Xjg.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_Xjg == null)
    {
      this.jdField_a_of_type_Xjg = new xjg(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_Xjg.a(new xag(this));
      this.jdField_a_of_type_Xjg.b(new xah(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362113));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new xaf(this));
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
  
  public void a(int paramInt, @NonNull xlb paramxlb)
  {
    super.a(paramInt, paramxlb);
    paramxlb.a.videoLabel = a();
    xan localxan;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localxan = this.jdField_a_of_type_Xan;
        str = a();
        if (!this.jdField_a_of_type_Xan.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramxlb = "2";; paramxlb = "1")
    {
      localxan.a("pub_tag", 0, 0, new String[] { "1", str, paramxlb });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Xjg != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Xjg.a() == 0)
      {
        this.jdField_a_of_type_Xan.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xae
 * JD-Core Version:    0.7.0.1
 */