import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public abstract class ucz<T>
{
  protected int a;
  protected View a;
  protected ReportExtraTypeInfo a;
  protected ExtraTypeInfo a;
  protected Object a;
  protected trr a;
  
  public ucz()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
  }
  
  private void a()
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_Trr != null))
    {
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType != 6) {
        break label81;
      }
      i = 1;
      if (i == 0) {
        break label86;
      }
    }
    label81:
    label86:
    for (String str = alpo.a(2131698328);; str = alpo.a(2131698329))
    {
      bdcd.a(this.jdField_a_of_type_AndroidViewView.getContext(), 230, "", str, new udb(this), new udc(this)).show();
      return;
      i = 0;
      break;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public FeedCloudMeta.StFeed a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) {
      return (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (tym.a().c(57))
    {
      tyk.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      return;
    }
    tyg.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(FeedCloudMeta.StUser paramStUser, String paramString, QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if ((paramStUser != null) && (!TextUtils.isEmpty(paramStUser.nick.get())) && (!TextUtils.isEmpty(paramString)) && (paramQCircleAsyncTextView != null))
    {
      paramQCircleAsyncTextView.b();
      paramQCircleAsyncTextView.a(0, paramStUser.nick.get().length() - 1, new uda(this, paramStUser));
      paramQCircleAsyncTextView.c();
      paramQCircleAsyncTextView.setText(paramStUser.nick.get().trim() + ":" + paramString);
      paramQCircleAsyncTextView.setVisibility(0);
      paramQCircleAsyncTextView.postInvalidate();
    }
  }
  
  public void a(trr paramtrr)
  {
    this.jdField_a_of_type_Trr = paramtrr;
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
    {
      String str = ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).id.get();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("qcircle_fakeid_"))) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, 2131698357, 0).a();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Trr != null)
    {
      boolean bool = this.jdField_a_of_type_Trr.a();
      if (bool)
      {
        if (this.jdField_a_of_type_Trr.a() != 2) {
          break label36;
        }
        a();
      }
      label36:
      while (this.jdField_a_of_type_Trr.a() != 4) {
        return bool;
      }
      QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, 2131698348, 0).a();
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ucz
 * JD-Core Version:    0.7.0.1
 */