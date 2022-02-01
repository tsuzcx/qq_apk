import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.1;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.2;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.3;
import com.tencent.mobileqq.activity.ChatHistoryEmotionView.4;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GestureSelectGridView.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class unt
  extends uou
  implements Handler.Callback, AbsListView.e, AdapterView.c, GestureSelectGridView.b
{
  long FG = 0L;
  private afrn a;
  public ChatHistoryEmotionAdapter a;
  public unt.a a;
  private boolean aTT;
  private boolean aTU;
  private boolean aTV;
  public boolean aTW = false;
  private int bFu;
  private final auru e = new auru(Looper.getMainLooper(), this);
  private Activity mActivity;
  private int mCurType;
  private View mEmptyView;
  private String mFriendUin;
  private GestureSelectGridView mGridView;
  private int mMaxIndex = -2147483648;
  private int mMinIndex = 2147483647;
  private View mSubView;
  
  private boolean a(afrq paramafrq, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity != null) {
      if (paramafrq.isSelected != paramBoolean)
      {
        if (!paramBoolean) {
          break label46;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.Pm()) {
          return false;
        }
        paramafrq.isSelected = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a(paramafrq);
      }
    }
    for (;;)
    {
      return true;
      label46:
      paramafrq.isSelected = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b(paramafrq);
      continue;
      if ((this.jdField_a_of_type_Unt$a != null) && (paramafrq.isSelected != paramBoolean))
      {
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_Unt$a.Pm()) {
            break;
          }
          paramafrq.isSelected = true;
          this.jdField_a_of_type_Unt$a.a(paramafrq);
          continue;
        }
        paramafrq.isSelected = false;
        this.jdField_a_of_type_Unt$a.b(paramafrq);
      }
    }
  }
  
  public boolean Pl()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.Pl();
    }
    return false;
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mActivity = ((Activity)paramContext);
    this.mCurType = paramIntent.getIntExtra("uintype", -1);
    this.mFriendUin = paramIntent.getStringExtra("uin");
    this.FG = paramIntent.getLongExtra("msg_revoke_uniseq", 0L);
    this.jdField_a_of_type_Afrn = new afrn(this.mFriendUin, this.mCurType);
    this.mSubView = LayoutInflater.from(paramContext).inflate(2131561040, null);
    this.mGridView = ((GestureSelectGridView)this.mSubView.findViewById(2131368142));
    this.mGridView.setSelectMode(false);
    this.mEmptyView = this.mSubView.findViewById(2131366437);
    if (AppSetting.enableTalkBack) {
      this.mEmptyView.setContentDescription(this.mActivity.getString(2131693652));
    }
    int i = this.mActivity.getResources().getDimensionPixelSize(2131297813);
    int j = this.mActivity.getResources().getDimensionPixelSize(2131297814);
    int k = this.mActivity.getResources().getDimensionPixelSize(2131297815);
    int m = (aqnm.getScreenWidth() - i * 2 - j * 3) / 4;
    this.mGridView.setGravity(3);
    this.mGridView.setScrollBarStyle(0);
    this.mGridView.setNumColumns(4);
    this.mGridView.setColumnWidth(m);
    this.mGridView.setHorizontalSpacing(j);
    this.mGridView.setVerticalSpacing(k);
    this.mGridView.setPadding(i, this.mGridView.getPaddingTop(), i, this.mGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter = new ChatHistoryEmotionAdapter(this.mActivity, this.jdField_a_of_type_Afrn, this.e, m, this.mGridView);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.zB(true);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.setCurType(this.mCurType);
    this.mGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter);
    this.mGridView.setOnItemClickListener(this);
    this.mGridView.setOnScrollListener(this);
    this.mGridView.setOnIndexChangedListener(this);
    this.mGridView.setSelectMode(false);
    this.mGridView.setTouchSlopRate(3);
    aqcl.Q(this.mGridView, false);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.ay(true);
    ThreadManager.excute(new ChatHistoryEmotionView.1(this), 32, null, false);
  }
  
  public View aI()
  {
    return this.mSubView;
  }
  
  public boolean bC()
  {
    return this.aTT;
  }
  
  public void bJW()
  {
    AbstractGifImage.resumeAll();
    this.aTW = true;
  }
  
  public void bJX()
  {
    AbstractGifImage.pauseAll();
    this.aTW = false;
  }
  
  public void bJY()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.aTT)
    {
      this.aTT = true;
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.aTT = true;
      this.mGridView.setSelectMode(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.notifyDataSetChanged();
    }
  }
  
  public void bJZ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.aTT)
    {
      this.aTT = false;
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.aTT = false;
      this.mGridView.setSelectMode(false);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.notifyDataSetChanged();
    }
  }
  
  public void cg()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.onDestory();
  }
  
  public void expandAll()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.expandAll();
    }
  }
  
  public void fG(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.eO();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((MessageRecord)((Iterator)localObject).next()).uniseq != paramLong);
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryEmotionView", 2, "onRevokeMsg notContain seq:" + paramLong);
        }
        return;
      }
      if (paramLong == this.FG)
      {
        this.e.post(new ChatHistoryEmotionView.4(this));
        return;
      }
      refreshData();
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label86:
    label112:
    for (;;)
    {
      return false;
      Object localObject;
      if (paramMessage.obj == null)
      {
        localObject = new ArrayList();
        if (paramMessage.arg1 != 1) {
          break label86;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.kx((List)localObject);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Unt$a == null) {
          break label112;
        }
        this.jdField_a_of_type_Unt$a.bKa();
        return false;
        localObject = (List)paramMessage.obj;
        break;
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.ky((List)localObject);
        if (((List)localObject).isEmpty()) {
          this.mEmptyView.setVisibility(0);
        }
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getItem(paramInt);
    if (!afrq.class.isInstance(paramAdapterView)) {}
    for (;;)
    {
      return;
      paramAdapterView = (afrq)paramAdapterView;
      if (!this.aTT) {
        break;
      }
      if (!paramAdapterView.isSelected) {}
      for (boolean bool = true; a(paramAdapterView, bool); bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.notifyDataSetChanged();
        return;
      }
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.aTl = this.mFriendUin;
    localSessionInfo.cZ = this.mCurType;
    AIOEmotionFragment.a(paramView.getContext(), paramAdapterView.h, localSessionInfo, sxx.getViewRect(paramView));
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = this.mGridView.getLastVisiblePosition();
      int i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.wu();
      int j = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.wv();
      if (((paramInt >= i - 28) || (paramInt == i)) && (this.bFu != j))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatHistoryEmotionView", 2, "[onScroll] loadEmotion: mLastLoadingCount=" + this.bFu);
        }
        this.bFu = j;
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.ay(true);
        ThreadManager.excute(new ChatHistoryEmotionView.3(this), 32, null, false);
      }
    }
  }
  
  public void onSelectBegin(int paramInt)
  {
    if (!this.aTT) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.wu() <= paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.j(paramInt);
    } while (!afrq.class.isInstance(localObject));
    Object localObject = (afrq)localObject;
    this.aTV = ((afrq)localObject).isSelected;
    if (!this.aTV) {}
    for (boolean bool = true;; bool = false)
    {
      if (a((afrq)localObject, bool)) {
        this.mGridView.invalidateViews();
      }
      this.aTU = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatHistoryEmotionView", 2, "onSelectBegin");
      return;
    }
  }
  
  public void onSelectChanged(int paramInt1, int paramInt2)
  {
    if (!this.aTT) {}
    while (!this.aTU) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionView", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.mMinIndex > paramInt2)
      {
        this.mMinIndex = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label177;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.j(paramInt1);
        if (afrq.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.mMaxIndex < paramInt2) {
        this.mMaxIndex = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    Object localObject = (afrq)localObject;
    if (!this.aTV) {}
    for (boolean bool = true;; bool = false)
    {
      a((afrq)localObject, bool);
      break;
    }
    label177:
    paramInt1 = j + 1;
    if (paramInt1 <= this.mMaxIndex)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.j(paramInt1);
      if (!afrq.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((afrq)localObject, this.aTV);
      }
    }
    paramInt1 = this.mMinIndex;
    if (paramInt1 < i)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.j(paramInt1);
      if (!afrq.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        a((afrq)localObject, this.aTV);
      }
    }
    this.mGridView.invalidateViews();
  }
  
  public void onSelectEnd()
  {
    if (!this.aTT) {}
    do
    {
      do
      {
        return;
      } while (!this.aTU);
      this.aTU = false;
      this.aTV = false;
      this.mMaxIndex = -2147483648;
      this.mMinIndex = 2147483647;
    } while (!QLog.isColorLevel());
    QLog.d("ChatHistoryEmotionView", 2, "onSelectEnd");
  }
  
  public void refreshData()
  {
    ThreadManager.excute(new ChatHistoryEmotionView.2(this), 32, null, false);
  }
  
  public static abstract interface a
  {
    public abstract boolean Pm();
    
    public abstract void a(afrq paramafrq);
    
    public abstract void b(afrq paramafrq);
    
    public abstract void bKa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     unt
 * JD-Core Version:    0.7.0.1
 */