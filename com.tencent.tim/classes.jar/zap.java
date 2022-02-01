import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.1;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.widget.SingleLineTextView;

public class zap
  extends yzr
{
  static final int[] fA = { 2131371299, 2131371299 };
  public static final int[] fy = { 2131692012, 2131692013 };
  static final int[] fz = { 2130839770, 2130839770 };
  amhj jdField_a_of_type_Amhj;
  OlympicManager jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager;
  private int bvK = 0;
  public Friends f;
  public acff h;
  
  public zap(QQAppInterface paramQQAppInterface, Context paramContext, Entity paramEntity)
  {
    super(paramQQAppInterface, paramContext, paramEntity);
    this.h = ((acff)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Amhj = ((amhj)paramQQAppInterface.getManager(15));
    this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager = ((OlympicManager)paramQQAppInterface.getManager(167));
    this.f = ((Friends)paramEntity);
    cny();
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.excute(new BuddyListFriends.1(this), 16, null, true);
      return;
    }
    this.h.a(this.f.uin);
  }
  
  private void cny()
  {
    this.jdField_a_of_type_Auvd = a(this.mContext);
    SpecialCareInfo localSpecialCareInfo = this.h.a(this.f.uin);
    if ((localSpecialCareInfo == null) || (localSpecialCareInfo.globalSwitch == 0))
    {
      this.mMenuFlag &= 0xFFFFFFFE;
      return;
    }
    this.mMenuFlag |= 0x1;
  }
  
  public void EX(int paramInt)
  {
    this.bvK = paramInt;
  }
  
  protected int[] F()
  {
    return fA;
  }
  
  protected int[] G()
  {
    return fy;
  }
  
  protected int[] H()
  {
    return fz;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.mApp.getManager(11);
    int i;
    Object localObject;
    label128:
    label193:
    label223:
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof zap.a)) || (((paramView.getTag() instanceof zap.a)) && (!((zap.a)paramView.getTag()).bqn))) {
      if (this.bvK == 1)
      {
        i = 2131559076;
        localObject = LayoutInflater.from(this.mContext).inflate(i, null);
        paramViewGroup = ((FriendItemLayout)localObject).a();
        paramView = this.jdField_a_of_type_Auvd.a(this.mContext, (View)localObject, paramViewGroup, -1);
        paramViewGroup.bqn = true;
        paramView.setTag(paramViewGroup);
        fN(((View)localObject).findViewById(2131368698));
        cny();
        paramViewGroup.item = this.f;
        paramViewGroup.uin = this.f.uin;
        i = aqgv.aU(this.f.detalStatusFlag, this.f.iTermType);
        paramViewGroup.bqo = false;
        if ((i != 0) && (i != 6)) {
          break label555;
        }
        i = 1;
        if ((localPhoneContactManagerImp.KG & 1L) != 1L)
        {
          localObject = aH();
          ImageView localImageView = paramViewGroup.pQ;
          if (i == 0) {
            break label561;
          }
          localImageView.setImageDrawable((Drawable)localObject);
          if (i == 0) {
            break label567;
          }
          bool = true;
          label238:
          paramViewGroup.bqo = bool;
        }
        if (((i == 0) || ((localPhoneContactManagerImp.KG & 0x8) == 8L)) && (!aqft.rj(this.f.uin))) {
          break label573;
        }
        paramViewGroup.xp.setImageDrawable(null);
        paramViewGroup.xp.setVisibility(8);
        label298:
        if (aqft.rj(this.f.uin)) {
          paramViewGroup.bqo = false;
        }
        paramViewGroup.uO.setVisibility(8);
        anlm.ayn();
        paramViewGroup.l.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        localObject = this.f.getFriendNickWithAlias();
        paramViewGroup.l.setText((CharSequence)localObject);
        paramViewGroup.az.setVisibility(8);
        if ((paramViewGroup != null) && (paramViewGroup.l != null) && (this.f != null)) {
          amip.a(paramViewGroup.l.getContext(), paramViewGroup.l, this.f.uin);
        }
        a(paramView, paramInt1 << 16 | paramInt2, paramViewGroup, paramOnClickListener);
        if (AppSetting.enableTalkBack)
        {
          paramViewGroup = paramViewGroup.H;
          if (paramViewGroup != null) {
            break label651;
          }
          paramViewGroup = new StringBuilder(24);
        }
      }
    }
    for (;;)
    {
      paramOnClickListener = null;
      localObject = this.h.a(this.f.uin, false);
      if (((localObject == null) || (TextUtils.isEmpty(((ExtensionInfo)localObject).feedContent))) || (localObject != null)) {
        paramOnClickListener = ((ExtensionInfo)localObject).getRichStatus(false);
      }
      if ((paramOnClickListener != null) && (paramOnClickListener != RichStatus.getEmptyStatus()) && (!paramOnClickListener.isEmpty())) {}
      paramView.setContentDescription(paramViewGroup);
      return paramView;
      i = 2131559075;
      break;
      paramViewGroup = (zap.a)paramView.getTag();
      break label128;
      label555:
      i = 0;
      break label193;
      label561:
      localObject = null;
      break label223;
      label567:
      bool = false;
      break label238;
      label573:
      localObject = aqgv.E(this.f.netTypeIconId);
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        paramViewGroup.xp.setImageDrawable((Drawable)localObject);
        paramViewGroup.xp.setVisibility(0);
        break label298;
      }
      paramViewGroup.xp.setImageDrawable(null);
      paramViewGroup.xp.setVisibility(8);
      break label298;
      label651:
      paramViewGroup.delete(0, paramViewGroup.length());
    }
  }
  
  protected void a(int paramInt, auvd.b[] paramArrayOfb)
  {
    paramInt = 1;
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {}
    label91:
    for (;;)
    {
      return;
      if ((paramArrayOfb.length < 0) && (this.f.isFriend())) {
        if ((this.mMenuFlag & 0x1) == 1)
        {
          paramArrayOfb[0].dOf = 0;
          paramArrayOfb[0].dOe = 0;
        }
      }
      for (;;)
      {
        if (paramInt >= paramArrayOfb.length) {
          break label91;
        }
        paramArrayOfb[paramInt].dOf = -1;
        paramArrayOfb[paramInt].dOe = -1;
        paramInt += 1;
        continue;
        paramArrayOfb[0].dOf = 1;
        break;
        paramInt = 0;
      }
    }
  }
  
  protected void fN(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new auvj();
      }
      paramView.a.setSupportMaskView(true);
    }
  }
  
  public static class a
    extends yzr.b
  {
    public StringBuilder H;
    public OnlineStatusView a;
    public URLImageView ay;
    public URLImageView az;
    public MutualMarkIconsView b;
    public boolean bqn;
    public boolean bqo;
    public SimpleTextView d;
    public LinearLayout hE;
    public ImageView uL;
    public ImageView uN;
    public ImageView uO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zap
 * JD-Core Version:    0.7.0.1
 */