import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.PressDarkImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class acyi
  extends ReportDialog
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public View AZ;
  acyi.a jdField_a_of_type_Acyi$a;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  FlashChatManager jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager;
  ListView b;
  acjf c;
  int dialogType = 0;
  List<QIMNotifyAddFriend> mDatas = new ArrayList();
  List<QIMNotifyAddFriend> rt = new LinkedList();
  
  public acyi(@NonNull BaseActivity paramBaseActivity, @NonNull ArrayList<QIMNotifyAddFriend> paramArrayList)
  {
    super(paramBaseActivity, 2131755365);
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {
      throw new RuntimeException("empty data");
    }
    getWindow().setDimAmount(0.5F);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.c = ((acjf)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getManager(257));
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface().getManager(217));
    this.mDatas.addAll(paramArrayList);
    this.rt.addAll(this.mDatas);
    if (this.mDatas.size() == 1)
    {
      paramArrayList = bS();
      anot.a(null, "dc00898", "", "", "0X8008A9E", "0X8008A9E", 0, 0, "", "", "", "");
      this.dialogType = 1;
      getWindow().getDecorView().setOnClickListener(this);
      setContentView(paramArrayList);
      paramBaseActivity = ((FlashChatManager)paramBaseActivity.app.getManager(217)).a.bKc;
      if (!TextUtils.isEmpty(paramBaseActivity))
      {
        paramArrayList = (ImageView)paramArrayList.findViewById(2131374667);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        paramBaseActivity = URLDrawable.getDrawable(paramBaseActivity, localURLDrawableOptions);
        if ((paramBaseActivity.getStatus() != 2) && (paramBaseActivity.getStatus() != 3)) {
          break label349;
        }
        paramBaseActivity.restartDownload();
      }
    }
    for (;;)
    {
      paramArrayList.setImageDrawable(paramBaseActivity);
      if (this.mDatas.size() != 1) {
        cOX();
      }
      return;
      paramArrayList = bR();
      anot.a(null, "dc00898", "", "", "0X8008AA1", "0X8008AA1", 0, 0, "", "", "", "");
      this.dialogType = 2;
      break;
      label349:
      paramBaseActivity.startDownload();
    }
  }
  
  private View bR()
  {
    List localList = this.mDatas;
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561094, null, false);
    localView.findViewById(2131370191).setOnClickListener(this);
    localView.findViewById(2131364677).setOnClickListener(this);
    TextView localTextView = (TextView)localView.findViewById(2131372334);
    String str = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager.wf();
    if (!TextUtils.isEmpty(str)) {
      localTextView.setText(str);
    }
    this.b = ((XListView)localView.findViewById(2131370527));
    this.b.setSelector(new ColorDrawable(0));
    this.jdField_a_of_type_Acyi$a = new acyi.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
    this.jdField_a_of_type_Acyi$a.setData(localList);
    this.b.setAdapter(this.jdField_a_of_type_Acyi$a);
    ((Button)localView.findViewById(2131365219)).setOnClickListener(this);
    return localView;
  }
  
  private View bS()
  {
    Object localObject1 = (QIMNotifyAddFriend)this.mDatas.get(0);
    this.rt.add(localObject1);
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131561137, null, false);
    localRelativeLayout.setOnClickListener(this);
    this.AZ = localRelativeLayout;
    Object localObject2 = localRelativeLayout.findViewById(2131365883);
    ((View)localObject2).setOnClickListener(this);
    Object localObject3 = (RelativeLayout.LayoutParams)((View)localObject2).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject3).width = wja.dp2px(286.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    ((RelativeLayout.LayoutParams)localObject3).height = -2;
    ((RelativeLayout.LayoutParams)localObject3).addRule(13);
    localObject3 = new PressDarkImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((PressDarkImageView)localObject3).setId(2131364677);
    ((PressDarkImageView)localObject3).setImageResource(2130847409);
    Object localObject4 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131365883);
    ((RelativeLayout.LayoutParams)localObject4).addRule(14);
    ((RelativeLayout.LayoutParams)localObject4).topMargin = wja.dp2px(28.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
    localRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    ((PressDarkImageView)localObject3).setOnClickListener(this);
    localObject3 = (TextView)((View)localObject2).findViewById(2131365902);
    localObject4 = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager.wf();
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((TextView)localObject3).setText((CharSequence)localObject4);
    }
    localObject4 = (ImageView)((View)localObject2).findViewById(2131366644);
    Object localObject5 = (TextView)((View)localObject2).findViewById(2131372369);
    localObject3 = (TextView)((View)localObject2).findViewById(2131365070);
    ((View)localObject2).findViewById(2131365219).setOnClickListener(this);
    Object localObject6 = (TextView)((View)localObject2).findViewById(2131376866);
    ((TextView)localObject6).setTag(Long.valueOf(((QIMNotifyAddFriend)localObject1).uin));
    Object localObject7 = this.c.g(((QIMNotifyAddFriend)localObject1).uin, ((QIMNotifyAddFriend)localObject1).qqUin);
    label410:
    int i;
    int j;
    int k;
    if (TextUtils.isEmpty((CharSequence)localObject7))
    {
      ((TextView)localObject6).setVisibility(8);
      ((ImageView)localObject4).setImageDrawable(aqdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, String.valueOf(((QIMNotifyAddFriend)localObject1).uin), (byte)2));
      ((TextView)localObject5).setText(((QIMNotifyAddFriend)localObject1).nickName);
      localObject4 = ((QIMNotifyAddFriend)localObject1).wording;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label667;
      }
      ((TextView)localObject3).setText((CharSequence)localObject4);
      i = ((QIMNotifyAddFriend)localObject1).videoInfos.size();
      if (i > 0)
      {
        localObject2 = (LinearLayout)((View)localObject2).findViewById(2131378789);
        ((LinearLayout)localObject2).setVisibility(0);
        if (i != 1) {
          break label685;
        }
        localObject3 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        i = wja.dp2px(128.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        j = wja.dp2px(188.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        k = wja.dp2px(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        localObject4 = new LinearLayout.LayoutParams(i, j);
        ((LinearLayout.LayoutParams)localObject4).rightMargin = k;
        localObject5 = URLDrawable.URLDrawableOptions.obtain();
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130840068);
        ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((Drawable)localObject6);
        ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject6);
        localObject5 = URLDrawable.getDrawable(((QIMNotifyAddFriend.VideoInfo)((QIMNotifyAddFriend)localObject1).videoInfos.get(0)).coverUrl, (URLDrawable.URLDrawableOptions)localObject5);
        if ((((URLDrawable)localObject5).getStatus() != 2) && (((URLDrawable)localObject5).getStatus() != 3)) {
          break label677;
        }
        ((URLDrawable)localObject5).restartDownload();
      }
    }
    for (;;)
    {
      ((ImageView)localObject3).setImageDrawable((Drawable)localObject5);
      ((ImageView)localObject3).setOnClickListener(new acyj(this, ((QIMNotifyAddFriend.VideoInfo)((QIMNotifyAddFriend)localObject1).videoInfos.get(0)).videoVid));
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      return localRelativeLayout;
      ((TextView)localObject6).setVisibility(0);
      ((TextView)localObject6).setText((CharSequence)localObject7);
      break;
      label667:
      ((TextView)localObject3).setVisibility(8);
      break label410;
      label677:
      ((URLDrawable)localObject5).startDownload();
    }
    label685:
    localObject1 = ((QIMNotifyAddFriend)localObject1).videoInfos;
    if (((List)localObject1).size() > 3) {
      localObject1 = ((List)localObject1).subList(0, 3);
    }
    for (;;)
    {
      localObject3 = new ArrayList(3);
      i = 0;
      label726:
      if (i < ((List)localObject1).size())
      {
        localObject4 = (QIMNotifyAddFriend.VideoInfo)((List)localObject1).get(i);
        localObject5 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        j = wja.dp2px(76.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        k = wja.dp2px(122.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        int m = wja.dp2px(4.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources());
        localObject6 = new LinearLayout.LayoutParams(j, k);
        ((LinearLayout.LayoutParams)localObject6).rightMargin = m;
        localObject7 = URLDrawable.URLDrawableOptions.obtain();
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130840068);
        ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = localDrawable;
        ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = localDrawable;
        localObject7 = URLDrawable.getDrawable(((QIMNotifyAddFriend.VideoInfo)localObject4).coverUrl, (URLDrawable.URLDrawableOptions)localObject7);
        if ((((URLDrawable)localObject7).getStatus() != 2) && (((URLDrawable)localObject7).getStatus() != 3)) {
          break label944;
        }
        ((URLDrawable)localObject7).restartDownload();
      }
      for (;;)
      {
        ((URLImageView)localObject5).setImageDrawable((Drawable)localObject7);
        ((ArrayList)localObject3).add(((QIMNotifyAddFriend.VideoInfo)localObject4).videoVid);
        ((URLImageView)localObject5).setOnClickListener(new acyk(this, (ArrayList)localObject3, (QIMNotifyAddFriend.VideoInfo)localObject4));
        ((LinearLayout)localObject2).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
        i += 1;
        break label726;
        break;
        label944:
        ((URLDrawable)localObject7).startDownload();
      }
    }
  }
  
  public boolean al(List<QIMNotifyAddFriend> paramList)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Acyi$a != null)
    {
      this.mDatas.addAll(0, paramList);
      this.rt.addAll(paramList);
      this.jdField_a_of_type_Acyi$a.setData(this.mDatas);
      cOX();
      bool = true;
    }
    return bool;
  }
  
  public void cOX()
  {
    Button localButton = (Button)getWindow().findViewById(2131365219);
    localButton.setOnClickListener(this);
    localButton.setText("OK（" + this.rt.size() + "）");
    if (!this.rt.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = paramCompoundButton.getTag();
    if ((localObject instanceof QIMNotifyAddFriend))
    {
      localObject = (QIMNotifyAddFriend)localObject;
      if (!paramBoolean) {
        break label58;
      }
      if (!this.rt.contains(localObject)) {
        this.rt.add(localObject);
      }
    }
    for (;;)
    {
      cOX();
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      label58:
      if (this.rt.contains(localObject)) {
        this.rt.remove(localObject);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if ((this.AZ == paramView) || (paramView == getWindow().getDecorView())) {
        dismiss();
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
      ((FriendListHandler)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(1)).iM(this.rt);
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager.a(getContext(), null);
      this.c.jd(this.rt);
      if (this.dialogType == 1)
      {
        anot.a(null, "dc00898", "", "", "0X8008A9F", "0X8008A9F", 0, 0, "", "", "", "");
      }
      else if (this.dialogType == 2)
      {
        anot.a(null, "dc00898", "", "", "0X8008AA2", "0X8008AA2", 0, 0, "", "", "", "");
        continue;
        if (this.dialogType == 1) {
          anot.a(null, "dc00898", "", "", "0X8008AA0", "0X8008AA0", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          dismiss();
          break;
          if (this.dialogType == 2) {
            anot.a(null, "dc00898", "", "", "0X8008AA3", "0X8008AA3", 0, 0, "", "", "", "");
          }
        }
        dismiss();
      }
    }
  }
  
  class a
    extends auvp
  {
    int aTw = 0;
    int aTx = 0;
    QQAppInterface mApp;
    Context mContext;
    List<QIMNotifyAddFriend> mDatas = new ArrayList();
    LayoutInflater mInflater;
    
    public a(Context paramContext, QQAppInterface paramQQAppInterface)
    {
      this.mContext = paramContext;
      this.mInflater = LayoutInflater.from(paramContext);
      this.mApp = paramQQAppInterface;
      this.aTw = paramContext.getResources().getDimensionPixelOffset(2131298495);
      this.aTx = paramContext.getResources().getDimensionPixelOffset(2131298494);
    }
    
    public int getCount()
    {
      return this.mDatas.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.mDatas.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      acyi.b localb;
      QIMNotifyAddFriend localQIMNotifyAddFriend;
      Object localObject1;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(2131561121, null);
        localb = new acyi.b(acyi.this);
        localb.ss = ((ImageView)paramView.findViewById(2131369739));
        localb.G = ((CheckBox)paramView.findViewById(2131364368));
        localb.Qs = ((TextView)paramView.findViewById(2131380821));
        localb.Qt = ((TextView)paramView.findViewById(2131380941));
        localb.io = ((LinearLayout)paramView.findViewById(2131370647));
        paramView.setTag(localb);
        localQIMNotifyAddFriend = (QIMNotifyAddFriend)getItem(paramInt);
        localb.G.setTag(localQIMNotifyAddFriend);
        localb.G.setOnCheckedChangeListener(acyi.this);
        localb.G.setChecked(acyi.this.rt.contains(localQIMNotifyAddFriend));
        localb.ss.setImageDrawable(aqdj.a(this.mApp, String.valueOf(localQIMNotifyAddFriend.uin), (byte)3));
        localb.Qs.setText(localQIMNotifyAddFriend.nickName);
        localb.Qt.setText(localQIMNotifyAddFriend.wording);
        localObject1 = acyi.this.c.g(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label486;
        }
        localb.Qt.setText((CharSequence)localObject1);
      }
      for (;;)
      {
        if (localQIMNotifyAddFriend.videoInfos.size() <= 0) {
          break label499;
        }
        localb.io.removeAllViews();
        localb.io.setVisibility(0);
        localObject1 = new ArrayList();
        int i = 0;
        while (i < localQIMNotifyAddFriend.videoInfos.size())
        {
          Object localObject2 = (QIMNotifyAddFriend.VideoInfo)localQIMNotifyAddFriend.videoInfos.get(i);
          URLImageView localURLImageView = new URLImageView(this.mContext);
          localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
          ((ArrayList)localObject1).add(((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid);
          localURLImageView.setOnClickListener(new acyl(this, (ArrayList)localObject1, ((QIMNotifyAddFriend.VideoInfo)localObject2).videoVid));
          rpq.a(localURLImageView, ((QIMNotifyAddFriend.VideoInfo)localObject2).coverUrl, this.aTw, this.aTx, 8, new ColorDrawable(-1), "Qim_First_Login_Recommend");
          localObject2 = new LinearLayout.LayoutParams(this.aTw, this.aTx);
          if (localb.io.getChildCount() != 0) {
            ((LinearLayout.LayoutParams)localObject2).setMargins(wja.dp2px(5.0F, this.mContext.getResources()), 0, 0, 0);
          }
          localb.io.addView(localURLImageView, (ViewGroup.LayoutParams)localObject2);
          i += 1;
        }
        localb = (acyi.b)paramView.getTag();
        break;
        label486:
        localb.Qt.setVisibility(8);
      }
      label499:
      localb.io.setVisibility(8);
      localb.uin = localQIMNotifyAddFriend.uin;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    
    public void setData(List<QIMNotifyAddFriend> paramList)
    {
      this.mDatas.clear();
      this.mDatas.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  class b
  {
    CheckBox G;
    TextView Qs;
    TextView Qt;
    LinearLayout io;
    ImageView ss;
    long uin;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyi
 * JD-Core Version:    0.7.0.1
 */