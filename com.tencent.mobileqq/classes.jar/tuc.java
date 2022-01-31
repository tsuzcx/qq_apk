import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCircleTopAuthPart.1;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.requests.QCircleConfirmCircleMemberShipRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import qqcircle.QQCircleBase.UserCircleInfo;
import qqcircle.QQCircleFeedBase.StFollowPageData;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class tuc
  extends tvv
  implements View.OnClickListener
{
  private final int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 8000L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString = "";
  private QQCircleBase.UserCircleInfo jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo;
  private final int jdField_b_of_type_Int = 2;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "";
  private final int jdField_c_of_type_Int = 3;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  private final int d = 4;
  private final int e = 5;
  private final int f = 1;
  private final int g = 2;
  private int h = -1;
  private int i = -1;
  
  private tsa a()
  {
    if ((a() != null) && ((a() instanceof QCircleBaseTabFragment))) {
      return ((QCircleBaseTabFragment)a()).a();
    }
    return null;
  }
  
  private void a()
  {
    if ((this.i == 1) || (this.i == 2))
    {
      Context localContext;
      List localList;
      if (a() != null)
      {
        localContext = a();
        localList = a().a.urlInfo.get();
        if (this.i != 1) {
          break label63;
        }
      }
      label63:
      for (String str = "authSchoolUrl";; str = "authCampanyUrl")
      {
        tqs.a(localContext, tqr.a(localList, str));
        return;
      }
    }
    b();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      tpz.a().e();
      if ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) && (!a().isFinishing())) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while ((this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) || (a().isFinishing())) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b()
  {
    bhuf localbhuf = bhuf.a(a());
    localbhuf.a(2131698352, 0);
    localbhuf.a(2131698351, 0);
    localbhuf.c(2131690648);
    localbhuf.a(new tud(this, localbhuf));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
  }
  
  private void b(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    tsa localtsa = a();
    if ((localtsa != null) && (localtsa.a() == 1) && (paramStFollowPageData != null) && (paramStFollowPageData.has())) {
      c(paramStFollowPageData);
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo != null)
    {
      QCircleConfirmCircleMemberShipRequest localQCircleConfirmCircleMemberShipRequest = new QCircleConfirmCircleMemberShipRequest(null, this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo);
      VSNetworkHelper.a().a(localQCircleConfirmCircleMemberShipRequest, new tue(this));
    }
  }
  
  private void c(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    if (tpz.a().b())
    {
      this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo = ((QQCircleBase.UserCircleInfo)paramStFollowPageData.recomCircileCertification.get());
      paramStFollowPageData = paramStFollowPageData.tipsTitle.get();
      if (!TextUtils.isEmpty(paramStFollowPageData)) {}
    }
    else
    {
      return;
    }
    if (this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo.has())
    {
      switch (this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo.circleTab.get())
      {
      default: 
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFollowPageData);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a().getString(2131698285));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.h = this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo.circleTab.get();
      this.i = this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo.circleType.get();
      this.jdField_a_of_type_JavaLangString = (this.i + "");
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo.name.get();
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_QqcircleQQCircleBase$UserCircleInfo.id.get();
    }
    for (;;)
    {
      tzv.a("", 22, 2L, 0L, this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "");
      a(true);
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_JavaLangRunnable = new QCircleTopAuthPart.1(this);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
      return;
      this.h = -1;
      this.i = -1;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStFollowPageData);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(a().getString(2131698340));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public String a()
  {
    return "QCircleTopAuthPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131372556));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372557));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373146));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373147));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373149));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.myLooper());
    }
  }
  
  public void a(QQCircleFeedBase.StFollowPageData paramStFollowPageData)
  {
    b(paramStFollowPageData);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131373148: 
    default: 
    case 2131373149: 
    case 2131373147: 
      do
      {
        return;
        a(false);
        tzv.a("", 22, 6L, 0L, this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "");
        QQToast.a(a(), 0, 2131698281, 0).a();
        return;
        if (this.h == -1)
        {
          tzv.a("", 22, 3L);
          b();
          a(false);
          return;
        }
        if (this.h == 5)
        {
          tzv.a("", 22, 4L, 0L, this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "");
          tzv.a("", 22, 7L, 0L, this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "");
          a();
          a(false);
          return;
        }
      } while (this.h != 4);
      tzv.a("", 22, 4L, 0L, this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "");
      tzv.a("", 22, 8L, 0L, this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "");
      c();
      QQToast.a(a(), 2, 2131698274, 0).a();
      a(false);
      return;
    }
    tzv.a("", 22, 5L, 0L, this.jdField_a_of_type_JavaLangString, "", this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, "");
    a();
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tuc
 * JD-Core Version:    0.7.0.1
 */