package com.tencent.mobileqq.activity.contact.newfriend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
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
import efc;
import efd;
import efe;
import eff;
import efg;
import efh;
import efi;
import efj;
import efk;
import efl;
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
  public static final int d = 998;
  public static final int e = 999;
  public static final int f = 1000;
  public static final int g = 1100;
  public static final int h = 1001;
  public static final int i = 1002;
  public static final int j = 1003;
  public static final int k = 1012;
  public final long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @SuppressLint({"HandlerLeak"})
  public Handler a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eff(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new efk(this);
  private SystemMsgListAdapter jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new efh(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new efj(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new efi(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressDialog a;
  private SlideDetectListView.OnScrollToTopListener jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView$OnScrollToTopListener = new efl(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public final long b;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new efg(this);
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  public View d;
  private boolean d;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f;
  private int l = 0;
  private int m;
  private final int n = 0;
  private int o;
  
  public SystemMsgListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_b_of_type_Long = 500L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new efc(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(SystemMsgListAdapter.ViewHolder paramViewHolder, String paramString, int paramInt1, int paramInt2)
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
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    paramViewHolder.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    c(paramQQAppInterface);
    paramQQAppInterface.z();
    FriendSystemMsgController.a().a(paramQQAppInterface);
    ((NewFriendManager)paramQQAppInterface.getManager(32)).e();
  }
  
  private void a(XListView paramXListView, String paramString, Bitmap paramBitmap)
  {
    int i2;
    int i1;
    if (this.l == 0)
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
    a((structmsg.StructMsg)paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
    a(localIntent);
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(new efd(paramQQAppInterface));
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "sendReadConfirm is end!");
    }
  }
  
  private void d(boolean paramBoolean)
  {
    a(2, paramBoolean);
  }
  
  private void l()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
  }
  
  private void m()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
  }
  
  private void n()
  {
    a(2130904010);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131234581));
    this.jdField_d_of_type_AndroidViewView = findViewById(2131234582);
    p();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
  }
  
  private void o()
  {
    this.m = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter = new SystemMsgListAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.m);
    this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.Z, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (!(this.jdField_a_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.newfriendSystemMsgListView", 2, "initListData error");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.A();
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    j();
  }
  
  private void p()
  {
    if (this.jdField_e_of_type_AndroidViewView == null) {
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903634, null);
    }
    if (this.jdField_e_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(this.jdField_e_of_type_AndroidViewView);
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void q()
  {
    if (this.f) {}
    do
    {
      do
      {
        return;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562452), 0).b(a());
          return;
        }
      } while ((this.jdField_a_of_type_JavaUtilList.size() < 10) || (FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      this.f = true;
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().h();
    } while (!QLog.isColorLevel());
    QLog.i("Q.newfriendSystemMsgListView", 2, "loadNextPage.get next page.");
  }
  
  private void r()
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
    return getResources().getDimensionPixelSize(2131427376);
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
    n();
    o();
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
    paramViewHolder.jdField_a_of_type_JavaLangString = (((structmsg.StructMsg)localObject).req_uin.get() + "");
    paramViewHolder.jdField_b_of_type_JavaLangString = ((structmsg.StructMsg)localObject).msg.req_uin_nick.get();
    label363:
    if ((paramViewHolder.jdField_b_of_type_JavaLangString != null) && (!paramViewHolder.jdField_b_of_type_JavaLangString.equals("")))
    {
      a(paramViewHolder, paramViewHolder.jdField_a_of_type_JavaLangString, 0, 1);
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
      paramViewHolder.jdField_d_of_type_JavaLangString = ((structmsg.StructMsg)localObject).msg.msg_source.get();
      paramViewHolder.e.setVisibility(8);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131562960) + " " + paramViewHolder.jdField_d_of_type_JavaLangString);
      if (TextUtils.isEmpty(paramViewHolder.jdField_d_of_type_JavaLangString)) {
        break label463;
      }
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      label255:
      if (((structmsg.StructMsg)localObject).msg != null)
      {
        paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_describe.get());
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewHolder);
        paramViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((((structmsg.StructMsg)localObject).msg.msg_additional.get() == null) || (((structmsg.StructMsg)localObject).msg.msg_additional.get().equals(""))) {
          break label511;
        }
        if (TextUtils.isEmpty(((structmsg.StructMsg)localObject).msg.msg_qna.get())) {
          break label491;
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
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      return;
      paramViewHolder.jdField_b_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
      break;
      label463:
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setSingleLine(false);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
      break label255;
      label491:
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_additional.get());
      break label363;
      label511:
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((structmsg.StructMsg)localObject).msg.msg_describe.get());
      break label363;
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
  
  public void a(String paramString1, long paramLong1, int paramInt, String paramString2, long paramLong2)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, AutoRemarkActivity.class);
    localIntent.putExtra("param_mode", 1);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("infotime", paramLong1);
    localIntent.putExtra("allow_flag", paramInt);
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
    l();
    this.c = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.getCount() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.jdField_a_of_type_Int = FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b();
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    j();
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  protected void f()
  {
    super.f();
    this.c = false;
    this.jdField_e_of_type_Boolean = false;
  }
  
  protected void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
    FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void h()
  {
    super.h();
    m();
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void k()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter.a();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1012);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new efe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView
 * JD-Core Version:    0.7.0.1
 */