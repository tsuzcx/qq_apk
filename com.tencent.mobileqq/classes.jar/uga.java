import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public abstract class uga<T>
{
  protected int a;
  protected View a;
  protected ReportExtraTypeInfo a;
  protected ExtraTypeInfo a;
  protected Object a;
  protected trw a;
  
  public uga()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo = new ReportExtraTypeInfo();
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
    if (tzy.a().c(57))
    {
      tzw.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
      return;
    }
    tzs.a(paramInt, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
  }
  
  public void a(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void a(FeedCloudMeta.StUser paramStUser, String paramString, QCircleAsyncTextView paramQCircleAsyncTextView)
  {
    if ((paramStUser != null) && (!TextUtils.isEmpty(paramStUser.nick.get())) && (!TextUtils.isEmpty(paramString)) && (paramQCircleAsyncTextView != null))
    {
      paramQCircleAsyncTextView.setText("");
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append(paramStUser.nick.get()).append("：").append(paramString);
      paramQCircleAsyncTextView.a(localSpannableStringBuilder, 0, paramStUser.nick.get().length(), new ugb(this, paramStUser));
      paramQCircleAsyncTextView.c();
      paramQCircleAsyncTextView.setText(localSpannableStringBuilder);
      paramQCircleAsyncTextView.setVisibility(0);
    }
  }
  
  public void a(trw paramtrw)
  {
    this.jdField_a_of_type_Trw = paramtrw;
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
        QQToast.a(this.jdField_a_of_type_AndroidViewView.getContext(), 0, 2131698369, 0).a();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uga
 * JD-Core Version:    0.7.0.1
 */