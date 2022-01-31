package com.tencent.mobileqq.activity.contact.newfriend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cdt;
import cdu;
import cdv;
import cdw;
import cdx;
import cdy;
import cdz;
import cea;
import ceb;
import cec;
import ced;
import cee;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter.ViewHolder;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.ViewHolder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.mobileqq.widget.SlideDetectListView.OnScrollToTopListener;
import com.tencent.mobileqq.widget.SlideDetectListView.OnSlideListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;

public class SystemMsgListView
  extends BaseNewFriendView
  implements BaseSystemMsgInterface, FaceDecoder.DecodeTaskCompletionListener, SlideDetectListView.OnScrollToTopListener, SlideDetectListView.OnSlideListener, Observer
{
  static final int jdField_a_of_type_Int = 60;
  private static final String jdField_a_of_type_JavaLangString = "Q.newfriendSystemMsgListView";
  public static final int b = 1012;
  public static final int c = 1013;
  public static final int d = 1014;
  public static final int e = 1015;
  public static final int f = 998;
  public static final int g = 999;
  public static final int h = 1000;
  public static final int i = 1100;
  public static final int j = 1001;
  public static final int k = 1002;
  public static final int l = 1003;
  public static final int m = 1012;
  public final long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @SuppressLint({"HandlerLeak"})
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new cdz(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new cdu(this);
  private SystemMsgListAdapter jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new cec(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new cee(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new ced(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressDialog a;
  private SlideDetectListView.OnScrollToTopListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener = new cdv(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public final long b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new cea(this);
  private boolean jdField_b_of_type_Boolean = true;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new ceb(this);
  public View c;
  private boolean jdField_c_of_type_Boolean = false;
  public View d;
  private boolean d;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f;
  private int n = 0;
  private int o;
  private final int p = 0;
  private int q;
  
  public SystemMsgListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new cdt(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    c(paramQQAppInterface);
    paramQQAppInterface.w();
    FriendSystemMsgController.a().a(paramQQAppInterface);
    ((NewFriendManager)paramQQAppInterface.getManager(31)).e();
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    int i2;
    int i1;
    if (this.n == 0)
    {
      i2 = paramXListView.getChildCount();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < i2)
      {
        SystemMsgListAdapter.ViewHolder localViewHolder = (SystemMsgListAdapter.ViewHolder)paramXListView.getChildAt(i1).getTag();
        if ((localViewHolder != null) && (paramString.equals(localViewHolder.jdField_a_of_type_JavaLangString))) {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l1);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  private boolean a(String paramString)
  {
    return ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).b(paramString);
  }
  
  private void b(SystemMsgListAdapter.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder == null) || (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    Object localObject1 = paramViewHolder.jdField_a_of_type_JavaLangString;
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)) {
      localObject1 = Long.toString(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    }
    for (;;)
    {
      if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null) {}
      for (int i1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();; i1 = 0)
      {
        Object localObject2;
        if ((i1 == 3007) || (i1 == 3019) || (i1 == 2007) || (i1 == 2019))
        {
          localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
          if ((localObject2 != null) && (((FriendManager)localObject2).b((String)localObject1))) {
            i1 = 0;
          }
        }
        for (;;)
        {
          if (i1 != 0)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(32, paramViewHolder.jdField_a_of_type_JavaLangString, 3000);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
              {
                this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_JavaLangString, 3000, true, false);
                localObject1 = localObject2;
              }
            }
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
                this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
              }
              localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
            }
            paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
            return;
            i1 = 1;
            break;
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, paramViewHolder.jdField_a_of_type_JavaLangString);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a())
              {
                this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramViewHolder.jdField_a_of_type_JavaLangString, 1, false);
                localObject1 = localObject2;
              }
            }
          }
          i1 = 0;
        }
      }
    }
  }
  
  private void b(SystemMsgListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.newfriendSystemMsgListView", 2, "jumpToAddRequestActivity!" + paramViewHolder.jdField_a_of_type_Long + ": dealMsgType = " + paramInt);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddRequestActivity.class);
    localIntent.putExtra("infoid", paramViewHolder.jdField_a_of_type_Long);
    localIntent.putExtra("infouin", paramViewHolder.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("infonick", paramViewHolder.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("infotime", paramViewHolder.jdField_b_of_type_Long);
    localIntent.putExtra("msg_type", paramViewHolder.jdField_a_of_type_Int);
    localIntent.putExtra("strNickName", paramViewHolder.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("verify_msg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    localIntent.putExtra("msg_source", paramViewHolder.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("msg_troopuin", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    localIntent.putExtra("system_message_summary", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
    localIntent.putExtra("info_dealwith_msg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
    localIntent.putExtra("msg_title", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
    localIntent.putExtra("msg_source_id", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
    a((structmsg.StructMsg)paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
    a(localIntent);
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(new cdw(paramQQAppInterface));
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void d(boolean paramBoolean)
  {
    a(2, paramBoolean);
  }
  
  private void m()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void n()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void o()
  {
    a(2130903555);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131298527));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131298528);
    this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903556, null);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    q();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  private void p()
  {
    this.o = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter = new SystemMsgListAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.o);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.ad, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter);
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.x();
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    j();
  }
  
  private void q()
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903553, null);
    }
    if (this.jdField_e_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(this.jdField_e_of_type_AndroidViewView);
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void r()
  {
    if (this.f) {}
    do
    {
      do
      {
        return;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362797), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_JavaUtilList.size() < 10) || (FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.f = true;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().h();
    } while (!QLog.isColorLevel());
    QLog.i("Q.newfriendSystemMsgListView", 2, "loadNextPage.get next page.");
  }
  
  private void s()
  {
    if (this.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    this.f = false;
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "stopLoadMore().");
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131492887);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, paramString, paramBitmap);
  }
  
  public void a(Intent paramIntent)
  {
    FriendSystemMsgController.a().e();
    super.a(paramIntent);
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    super.a(paramIntent, paramINewFriendContext);
    o();
    p();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollToTopListener(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
  }
  
  public void a(NotificationAdapter.ViewHolder paramViewHolder, int paramInt) {}
  
  public void a(SystemMsgListAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.newfriendSystemMsgListView", 2, "handleBuddySystemMsg! start " + paramViewHolder.jdField_a_of_type_Long);
    }
    structmsg.StructMsg localStructMsg = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    switch (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get())
    {
    case 0: 
    default: 
      return;
    case 1: 
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddRequestActivity.class);
      localIntent.putExtra("infoid", paramViewHolder.jdField_a_of_type_Long);
      localIntent.putExtra("infouin", paramViewHolder.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("infonick", paramViewHolder.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("infotime", paramViewHolder.jdField_b_of_type_Long);
      localIntent.putExtra("verify_msg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
      localIntent.putExtra("verify_type", 1);
      localIntent.putExtra("msg_source_id", localStructMsg.msg.src_id.get());
      localIntent.putExtra("msg_type", paramViewHolder.jdField_a_of_type_Int);
      localIntent.putExtra("strNickName", paramViewHolder.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("msg_source", paramViewHolder.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("system_message_summary", localStructMsg.msg.msg_describe.get());
      localIntent.putExtra("msg_troopuin", localStructMsg.msg.group_code.get());
      localIntent.putExtra("info_dealwith_msg", localStructMsg.msg.msg_detail.get());
      localIntent.putExtra("msg_title", localStructMsg.msg.msg_title.get());
      a((structmsg.StructMsg)localStructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
      a(localIntent);
      return;
    case 2: 
      b(paramViewHolder, 1000);
      return;
    case 3: 
      b(paramViewHolder, 1000);
      return;
    case 4: 
      b(paramViewHolder, 1002);
      return;
    case 5: 
      b(paramViewHolder, 1002);
      return;
    case 6: 
      b(paramViewHolder, 1003);
      return;
    case 7: 
      b(paramViewHolder, 1001);
      return;
    case 8: 
      b(paramViewHolder, 1012);
      return;
    case 9: 
      localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddRequestActivity.class);
      localIntent.putExtra("infoid", paramViewHolder.jdField_a_of_type_Long);
      localIntent.putExtra("infouin", paramViewHolder.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("infonick", paramViewHolder.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("infotime", paramViewHolder.jdField_b_of_type_Long);
      localIntent.putExtra("verify_msg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
      localIntent.putExtra("verify_type", 2);
      localIntent.putExtra("msg_type", paramViewHolder.jdField_a_of_type_Int);
      localIntent.putExtra("msg_source", paramViewHolder.jdField_d_of_type_JavaLangString);
      localIntent.putExtra("strNickName", paramViewHolder.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("system_message_summary", localStructMsg.msg.msg_describe.get());
      localIntent.putExtra("msg_source_id", localStructMsg.msg.src_id.get());
      localIntent.putExtra("msg_troopuin", localStructMsg.msg.group_code.get());
      localIntent.putExtra("info_dealwith_msg", localStructMsg.msg.msg_detail.get());
      localIntent.putExtra("msg_title", localStructMsg.msg.msg_title.get());
      a((structmsg.StructMsg)localStructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
      a(localIntent);
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AddRequestActivity.class);
    localIntent.putExtra("infoid", paramViewHolder.jdField_a_of_type_Long);
    localIntent.putExtra("infouin", paramViewHolder.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("infonick", paramViewHolder.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("infotime", paramViewHolder.jdField_b_of_type_Long);
    localIntent.putExtra("verify_msg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    localIntent.putExtra("verify_type", 2);
    localIntent.putExtra("msg_type", paramViewHolder.jdField_a_of_type_Int);
    localIntent.putExtra("msg_source", paramViewHolder.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("strNickName", paramViewHolder.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("system_message_summary", localStructMsg.msg.msg_describe.get());
    localIntent.putExtra("msg_source_id", localStructMsg.msg.src_id.get());
    localIntent.putExtra("msg_troopuin", localStructMsg.msg.group_code.get());
    localIntent.putExtra("info_dealwith_msg", localStructMsg.msg.msg_detail.get());
    localIntent.putExtra("msg_title", localStructMsg.msg.msg_title.get());
    a((structmsg.StructMsg)localStructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
    a(localIntent);
  }
  
  public void a(SystemMsgListAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramViewHolder.jdField_a_of_type_Long = paramInt;
    paramViewHolder.jdField_a_of_type_JavaLangString = (((structmsg.StructMsg)localObject).req_uin.get() + "");
    paramViewHolder.jdField_a_of_type_Int = ((structmsg.StructMsg)localObject).msg.sub_type.get();
    paramViewHolder.jdField_b_of_type_Long = ((structmsg.StructMsg)localObject).msg_time.get();
    paramViewHolder.jdField_b_of_type_JavaLangString = ((structmsg.StructMsg)localObject).msg.req_uin_nick.get();
    label413:
    if ((paramViewHolder.jdField_b_of_type_JavaLangString != null) && (!paramViewHolder.jdField_b_of_type_JavaLangString.equals("")))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
      paramViewHolder.jdField_d_of_type_JavaLangString = ((structmsg.StructMsg)localObject).msg.msg_source.get();
      paramInt = ((structmsg.StructMsg)localObject).msg.src_id.get();
      if ((((structmsg.StructMsg)localObject).msg.sub_type.get() != 6) && ((paramInt == 3016) || (paramInt == 2016)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("newfriend_sysmsg_game_add_friends_tips", true)))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1015);
        setIsShowGameAddFriendsTips(false);
      }
      b(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      paramViewHolder.e.setVisibility(8);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131362898) + " " + paramViewHolder.jdField_d_of_type_JavaLangString);
      if (TextUtils.isEmpty(paramViewHolder.jdField_d_of_type_JavaLangString)) {
        break label511;
      }
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label305:
      if (((structmsg.StructMsg)localObject).msg != null)
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_describe.get());
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewHolder);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        if ((((structmsg.StructMsg)localObject).msg.msg_additional.get() == null) || (((structmsg.StructMsg)localObject).msg.msg_additional.get().equals(""))) {
          break label559;
        }
        if (TextUtils.isEmpty(((structmsg.StructMsg)localObject).msg.msg_qna.get())) {
          break label539;
        }
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_qna.get());
        switch (((structmsg.StructMsg)localObject).msg.sub_type.get())
        {
        }
      }
    }
    for (;;)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      return;
      paramViewHolder.jdField_b_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      break;
      label511:
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
      break label305;
      label539:
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_additional.get());
      break label413;
      label559:
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_describe.get());
      break label413;
      if ((((structmsg.StructMsg)localObject).msg.actions.get() != null) && (((structmsg.StructMsg)localObject).msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)((structmsg.StructMsg)localObject).msg.actions.get().get(0)).name.get())))
      {
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        localObject = ((structmsg.SystemMsgAction)((structmsg.StructMsg)localObject).msg.actions.get().get(0)).name.get();
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
      }
      else if ((((structmsg.StructMsg)localObject).msg.actions.get() != null) && (((structmsg.StructMsg)localObject).msg.actions.get().size() == 0))
      {
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.setMargins(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density * 14.0F), 0);
        localObject = ((structmsg.StructMsg)localObject).msg.msg_decided.get();
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.setMargins(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density * 14.0F), 0);
        localObject = ((structmsg.StructMsg)localObject).msg.msg_decided.get();
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.setMargins(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density * 14.0F), 0);
        localObject = ((structmsg.StructMsg)localObject).msg.msg_decided.get();
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        if ((((structmsg.StructMsg)localObject).msg.msg_additional.get() != null) && (!((structmsg.StructMsg)localObject).msg.msg_additional.get().equals("")))
        {
          paramViewHolder.e.setText(((structmsg.StructMsg)localObject).msg.msg_additional.get());
          paramViewHolder.e.setVisibility(0);
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_describe.get());
        }
        for (;;)
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          paramViewHolder.e.setVisibility(8);
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
          paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
        }
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.setMargins(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density * 14.0F), 0);
        localObject = ((structmsg.StructMsg)localObject).msg.msg_decided.get();
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.setMargins(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density * 14.0F), 0);
        localObject = ((structmsg.StructMsg)localObject).msg.msg_decided.get();
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        continue;
        if ((((structmsg.StructMsg)localObject).msg.actions.get() != null) && (((structmsg.StructMsg)localObject).msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)((structmsg.StructMsg)localObject).msg.actions.get().get(0)).name.get())))
        {
          paramViewHolder.e.setVisibility(8);
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          localObject = ((structmsg.SystemMsgAction)((structmsg.StructMsg)localObject).msg.actions.get().get(0)).name.get();
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        }
        else
        {
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
          localLayoutParams.addRule(11);
          localLayoutParams.addRule(9, 0);
          localLayoutParams.setMargins(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density * 14.0F), 0);
          localObject = ((structmsg.StructMsg)localObject).msg.msg_decided.get();
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          continue;
          if ((((structmsg.StructMsg)localObject).msg.actions.get() != null) && (((structmsg.StructMsg)localObject).msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)((structmsg.StructMsg)localObject).msg.actions.get().get(0)).name.get())))
          {
            paramViewHolder.e.setVisibility(8);
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
            localObject = ((structmsg.SystemMsgAction)((structmsg.StructMsg)localObject).msg.actions.get().get(0)).name.get();
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
          }
          else
          {
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            localLayoutParams = (RelativeLayout.LayoutParams)paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(9, 0);
            localLayoutParams.setMargins(0, 0, (int)(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density * 14.0F), 0);
            localObject = ((structmsg.StructMsg)localObject).msg.msg_decided.get();
            paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
            paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
        }
      }
    }
  }
  
  public void a(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBusinessObserver);
    }
  }
  
  public void a(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(String paramString1, long paramLong1, String paramString2, long paramLong2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("infotime", paramLong1);
    localIntent.putExtra("refuse_reason", paramString2);
    localIntent.putExtra("db_id", paramLong2);
    a(localIntent, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.newfriendSystemMsgListView", 2, "startAutoRemarkActivity infomation friendUin:" + paramString1 + " infotime:" + paramLong1);
    }
  }
  
  public void a(String paramString1, long paramLong1, byte[] paramArrayOfByte, String paramString2, long paramLong2, long paramLong3)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 2);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("lToMobile", paramLong1);
    localIntent.putExtra("sig", paramArrayOfByte);
    localIntent.putExtra("nick_name", paramString2);
    localIntent.putExtra("infotime", paramLong2);
    localIntent.putExtra("db_id", paramLong3);
    a(localIntent, 0);
  }
  
  public boolean a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.k() > 0)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildCount() - 1);
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int i1 = arrayOfInt[1];
      if (paramFloat > localView.getMeasuredHeight() + i1) {
        return true;
      }
    }
    return false;
  }
  
  public void b(BusinessObserver paramBusinessObserver)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(paramBusinessObserver);
    }
  }
  
  public void b(SlideDetectListView paramSlideDetectListView, View paramView, int paramInt) {}
  
  protected void d()
  {
    super.d();
    a(true);
    d(false);
  }
  
  protected void e()
  {
    super.e();
    m();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.jdField_a_of_type_Int = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cdx(this));
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    j();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
    }
  }
  
  protected void f()
  {
    super.f();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  protected void h()
  {
    super.h();
    n();
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).getBoolean("newfriend_sysmsg_game_add_friends_tips", true)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.k() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_d_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(null);
    FriendSystemMsgController.a().b();
    if (this.jdField_d_of_type_Boolean) {
      FriendSystemMsgController.a().d();
    }
  }
  
  public void i()
  {
    FriendSystemMsgController.a().b();
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount() > 0)) {
      c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_d_of_type_Boolean = true;
    super.i();
  }
  
  public void j()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1014);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void l()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("title", this.jdField_a_of_type_AndroidContentContext.getString(2131364298));
    a(localIntent.putExtra("url", "http://ti.qq.com/friendship_auth/index.html?_wv=3&_bid=173#p1"));
  }
  
  public void setIsShowGameAddFriendsTips(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0).edit().putBoolean("newfriend_sysmsg_game_add_friends_tips", paramBoolean).commit();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new cdy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */