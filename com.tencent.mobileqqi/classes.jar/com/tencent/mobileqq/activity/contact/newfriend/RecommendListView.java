package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecommendContactMsg;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import eeq;
import eer;
import eet;
import eeu;
import eev;
import eex;
import eey;
import eez;
import efa;
import efb;
import efc;
import java.util.List;

public class RecommendListView
  extends BaseNewFriendView
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnScrollToTopListener, SlideDetectListView.OnSlideListener
{
  public static final int c = 0;
  public static final String c = "key_work_mode";
  public static final int d = 1;
  private static final int e = 1;
  private static final int f = 2;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Handler jdField_a_of_type_AndroidOsHandler = new eeq(this);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eet(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public SlideDetectListView a;
  private efa jdField_a_of_type_Efa;
  public efb a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  public List a;
  public int b;
  public long b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  private boolean jdField_b_of_type_Boolean = false;
  private long c;
  public View d;
  private int g = 0;
  private int h = 0;
  
  public RecommendListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(ListView paramListView, String paramString, Bitmap paramBitmap)
  {
    int j;
    int i;
    if (this.h == 0)
    {
      j = paramListView.getChildCount();
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        efc localefc = (efc)paramListView.getChildAt(i).getTag();
        if ((localefc != null) && (paramString.equals(localefc.jdField_a_of_type_JavaLangString))) {
          localefc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(efc paramefc, String paramString, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramInt2, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, paramInt2, false);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    paramefc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramefc.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private boolean c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131233084));
    this.d = findViewById(2131233085);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233083));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233082));
    if (this.g == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this);
    this.jdField_a_of_type_Efb = new efb(this, null);
    this.jdField_b_of_type_Boolean = true;
    Object localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localObject != null)
    {
      localObject = ((PhoneContactManager)localObject).d();
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break label237;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a() != this.jdField_a_of_type_Efb) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Efb);
      }
      this.jdField_a_of_type_Efb.notifyDataSetChanged();
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131559921, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) }));
    }
    for (;;)
    {
      return true;
      localObject = null;
      break;
      label237:
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setEmptyView(this.d);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    a(1, paramBoolean);
  }
  
  private void j()
  {
    a(2130903615);
    c();
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new eer(this));
  }
  
  private void l()
  {
    Object localObject = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new eev(this, (PhoneContactManagerImp)localObject);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    if (localObject != null)
    {
      if (this.g != 0) {
        break label60;
      }
      ((PhoneContactManagerImp)localObject).b();
    }
    label60:
    do
    {
      do
      {
        do
        {
          return;
          b();
        } while (!((PhoneContactManagerImp)localObject).b());
        c();
        if (((PhoneContactManagerImp)localObject).a() != 0) {
          break;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
      } while (!(localObject instanceof ContactRecommendActivity));
      ((ContactRecommendActivity)localObject).d();
    } while (!QLog.isColorLevel());
    QLog.d("RecommendListView", 2, "onGetRecommendedList startMainActivity");
    return;
    k();
  }
  
  private void m()
  {
    j();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendListView.class, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new eex(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    l();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) || (paramInt1 == 2)) {
      k();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, paramString, paramBitmap);
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    int i = 0;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("key_work_mode", 0);
    }
    this.g = i;
    super.a(paramIntent, paramINewFriendContext);
    m();
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_Efb.getCount())) {}
    do
    {
      return;
      this.jdField_a_of_type_Efb.jdField_a_of_type_Int = paramInt;
      View localView = paramView.findViewById(2131230987);
      if (localView != null)
      {
        Button localButton = (Button)localView.findViewById(2131230988);
        localButton.setTag(Integer.valueOf(paramInt));
        localButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((ShaderAnimLayout)localView).a();
        paramSlideDetectListView.setDeleteAreaWidth(localView.getLayoutParams().width);
      }
      paramSlideDetectListView = paramView.findViewById(2131234362);
      if (paramSlideDetectListView != null) {
        paramSlideDetectListView.setVisibility(4);
      }
      paramSlideDetectListView = paramView.findViewById(2131234363);
    } while (paramSlideDetectListView == null);
    paramSlideDetectListView.setVisibility(4);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.h = paramInt;
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        efc localefc = (efc)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(paramInt).getTag();
        if ((localefc != null) && (!TextUtils.isEmpty(localefc.jdField_a_of_type_JavaLangString)))
        {
          Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(11, localefc.jdField_a_of_type_JavaLangString);
          paramAbsListView = localBitmap;
          if (localBitmap == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(localefc.jdField_a_of_type_JavaLangString, 11, false);
            if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
              this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
            }
            paramAbsListView = this.jdField_a_of_type_AndroidGraphicsBitmap;
          }
          localefc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramAbsListView);
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt)
  {
    paramSlideDetectListView = this.jdField_a_of_type_Efb.getItem(paramInt);
    if (paramSlideDetectListView == null) {}
    View localView;
    do
    {
      do
      {
        Object localObject;
        do
        {
          return;
          paramSlideDetectListView = (RecommendContactMsg)paramSlideDetectListView;
          this.jdField_a_of_type_Efb.jdField_a_of_type_Int = -1;
          localObject = paramView.findViewById(2131230987);
          if (localObject != null)
          {
            ((ShaderAnimLayout)localObject).d();
            localObject = (Button)((View)localObject).findViewById(2131230988);
            ((Button)localObject).setTag(null);
            ((Button)localObject).setOnClickListener(null);
          }
          localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        } while (localObject == null);
        localView = paramView.findViewById(2131234362);
        paramView = paramView.findViewById(2131234363);
        if ((!((FriendManager)localObject).b(paramSlideDetectListView.uin)) && (!((FriendManager)localObject).e(paramSlideDetectListView.uin)) && (!((FriendManager)localObject).e(paramSlideDetectListView.nationCode + paramSlideDetectListView.mobileCode))) {
          break;
        }
      } while (paramView == null);
      paramView.postDelayed(new eey(this, paramView), 300L);
      return;
    } while (localView == null);
    localView.postDelayed(new eez(this, localView), 300L);
  }
  
  boolean b()
  {
    long l = System.currentTimeMillis();
    if (l - this.c > 500L)
    {
      this.c = l;
      return true;
    }
    return false;
  }
  
  protected void d()
  {
    super.d();
    if (this.g == 0)
    {
      a(true);
      d(false);
      return;
    }
    a(2131562933, new eeu(this));
  }
  
  protected void e()
  {
    super.e();
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Efb != null)) {
      this.jdField_a_of_type_Efb.notifyDataSetChanged();
    }
  }
  
  protected void f()
  {
    super.f();
    ((PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(this.jdField_a_of_type_JavaUtilList);
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
  }
  
  protected void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(RecommendListView.class);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    if (this.jdField_a_of_type_Efb != null) {
      this.jdField_a_of_type_Efb.a();
    }
    if (this.g == 0) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Frd_offer", "Clk_Frd_offer", 22, 0, this.jdField_a_of_type_Long + "", this.jdField_b_of_type_Long + "", this.jdField_a_of_type_JavaLangString + "&" + this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int + "");
    }
  }
  
  public void onClick(View paramView)
  {
    if (!b()) {}
    while (paramView.getId() != 2131234362) {
      return;
    }
    paramView = (RecommendContactMsg)paramView.getTag();
    Intent localIntent = new Intent(getContext(), AddFriendLogicActivity.class);
    if ((paramView.source != null) && (paramView.source.length() > 0))
    {
      localIntent.putExtra("type", 0);
      localIntent.putExtra("source_id", 3003);
      localIntent.putExtra("uin", paramView.uin);
      localIntent.putExtra("nick_name", paramView.nickName);
      localIntent.putExtra("param_last_activity_name", getContext().getString(2131562730));
      localIntent.putExtra("sub_source_id", 1);
      b(localIntent, 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "frd_recommend", "Frd_add", 0, 0, "", "", "", "");
      return;
    }
    if (paramView.originBinder == 3L)
    {
      localIntent.putExtra("type", 4);
      localIntent.putExtra("source_id", 3009);
    }
    for (;;)
    {
      localIntent.putExtra("uin", paramView.uin);
      localIntent.putExtra("friend_mobile_name", paramView.contactName);
      localIntent.putExtra("friend_mobile_number", paramView.nationCode + paramView.mobileCode);
      localIntent.putExtra("param_last_activity_name", getContext().getString(2131562730));
      localIntent.putExtra("sub_source_id", 1);
      break;
      localIntent.putExtra("type", 3);
      localIntent.putExtra("source_id", 3006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.RecommendListView
 * JD-Core Version:    0.7.0.1
 */