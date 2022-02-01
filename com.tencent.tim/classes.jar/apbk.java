import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopEntranceBar.1;
import com.tencent.mobileqq.troop.data.TroopEntranceBar.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody;

public class apbk
  extends Observable
  implements View.OnClickListener
{
  ImageView En;
  public List<TroopInfo> HE = new ArrayList();
  public List<String> HF = new ArrayList();
  protected View Ih;
  View Ij;
  View Ik;
  public wki a;
  public QQAppInterface app;
  public long aqR;
  private LightingColorFilter b;
  public ChatXListView b;
  protected acfd c;
  private LightingColorFilter c;
  public boolean cPI;
  public Context context;
  protected aqdf d;
  private int dSV;
  private int dSW;
  public int dSX;
  public int dSY;
  public int dSZ;
  private Drawable fB;
  private Drawable fC;
  private Drawable fD;
  public RelativeLayout fs;
  public Observer j;
  public Map<String, Integer> nz = new HashMap();
  public SessionInfo sessionInfo;
  TextView textView;
  
  public apbk()
  {
    this.jdField_c_of_type_Acfd = new apbk.a(this, null);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, wki paramwki, ChatXListView paramChatXListView)
  {
    this.app = paramQQAppInterface;
    this.context = paramContext;
    this.sessionInfo = paramSessionInfo;
    this.fs = paramRelativeLayout;
    if (this.fs != null) {
      this.Ih = this.fs.findViewById(2131374819);
    }
    this.a = paramwki;
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = paramChatXListView;
    this.j = paramObserver;
    deleteObservers();
    addObserver(paramObserver);
    paramQQAppInterface.addObserver(this.jdField_c_of_type_Acfd);
    this.d = new aqdf(paramContext, paramQQAppInterface);
    this.dSV = paramContext.getResources().getColor(2131166504);
    this.dSW = paramContext.getResources().getColor(2131166505);
    this.jdField_b_of_type_AndroidGraphicsLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.dSV);
    this.jdField_c_of_type_AndroidGraphicsLightingColorFilter = new LightingColorFilter(Color.argb(255, 0, 0, 0), this.dSW);
  }
  
  public void aU(long paramLong, int paramInt)
  {
    oidb_0x487.ReqBody localReqBody = new oidb_0x487.ReqBody();
    localReqBody.uint32_channel.set(1);
    localReqBody.uint64_subscribe_code.set(paramLong);
    jnm.b(this.app, new apbl(this, paramLong), localReqBody.toByteArray(), "OidbSvc.0x487_0", 1159, paramInt);
  }
  
  public void dYA()
  {
    if (!this.cPI) {
      return;
    }
    ImageView localImageView = (ImageView)this.Ij.findViewById(2131380206);
    localImageView.setVisibility(0);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
    localLayoutParams.height = -2;
    localLayoutParams.width = -2;
    localLayoutParams.leftMargin = aqcx.dip2px(this.context, 3.0F);
    localLayoutParams.rightMargin = aqcx.dip2px(this.context, 8.0F);
    Drawable localDrawable = this.context.getResources().getDrawable(2130844483);
    localLayoutParams.leftMargin = aqcx.dip2px(this.context, 11.0F);
    if (this.fB == null) {
      this.fB = localDrawable.getConstantState().newDrawable(this.context.getResources()).mutate();
    }
    this.fB.setColorFilter(this.jdField_b_of_type_AndroidGraphicsLightingColorFilter);
    localImageView.setImageDrawable(this.fB);
    this.textView.setTextColor(this.dSV);
    if (this.fC == null) {
      this.fC = this.fD.getConstantState().newDrawable(this.context.getResources()).mutate();
    }
    this.fC.setColorFilter(this.jdField_b_of_type_AndroidGraphicsLightingColorFilter);
    this.En.setImageDrawable(this.fC);
    this.textView.setText(2131699893);
  }
  
  public void dYB()
  {
    Iterator localIterator = this.nz.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((Integer)localIterator.next()).intValue() + l) {}
    this.aqR = l;
  }
  
  public void dYC()
  {
    String str1;
    QQAppInterface localQQAppInterface;
    if (this.dSY <= 0)
    {
      this.dSZ = 0;
      str1 = "entry_none";
      localQQAppInterface = this.app;
      if (this.sessionInfo != null) {
        break label128;
      }
    }
    label128:
    for (String str2 = "";; str2 = this.sessionInfo.aTl)
    {
      anot.a(localQQAppInterface, "P_CliOper", "Grp_public", "", "oper", str1, 0, 0, "", "", "", str2);
      return;
      if (this.dSY == 1)
      {
        if (this.aqR <= 0L) {}
        for (this.dSZ = 3;; this.dSZ = 1)
        {
          str1 = "entry_one";
          break;
        }
      }
      if (this.aqR <= 0L) {}
      for (this.dSZ = 4;; this.dSZ = 2)
      {
        str1 = "entry_more";
        break;
      }
    }
  }
  
  public void dYD()
  {
    Object localObject1 = ((TroopManager)this.app.getManager(52)).cE();
    try
    {
      long l = Long.valueOf(this.sessionInfo.aTl).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l)
          {
            this.dSY += 1;
            this.HE.add(localObject2);
          }
        }
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d(".troop.troop_pubaccount", 2, "publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is " + this.sessionInfo.aTl);
    }
  }
  
  public void dYz()
  {
    if ((this.fs == null) || (this.cPI)) {
      return;
    }
    if (this.Ik == null) {
      this.Ik = LayoutInflater.from(this.context).inflate(2131560754, null);
    }
    if (this.fs.indexOfChild(this.Ik) == -1)
    {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this.context, 18.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131374819);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).height = aqcx.dip2px(this.context, 41.0F);
      this.fs.addView(this.Ik, (ViewGroup.LayoutParams)localObject);
    }
    if (this.Ij == null) {
      this.Ij = this.Ik.findViewById(2131380204);
    }
    this.textView = ((TextView)this.Ij.findViewById(2131380207));
    this.En = ((ImageView)this.Ij.findViewById(2131380205));
    Object localObject = (LinearLayout.LayoutParams)this.En.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = aqcx.dip2px(this.context, 4.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(this.context, 5.0F);
    int i = aqcx.dip2px(this.context, 18.0F);
    ((LinearLayout.LayoutParams)localObject).height = i;
    ((LinearLayout.LayoutParams)localObject).width = i;
    this.En.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (ThemeUtil.isInNightMode(this.app)) {
      this.Ij.setBackgroundResource(2130851777);
    }
    for (;;)
    {
      this.fD = this.context.getResources().getDrawable(2130844482);
      this.Ij.setOnClickListener(this);
      this.cPI = true;
      dYA();
      this.Ik.setVisibility(8);
      ThreadManager.post(new TroopEntranceBar.1(this), 8, null, true);
      return;
      this.Ij.setBackgroundResource(2130851778);
    }
  }
  
  public void em(QQAppInterface paramQQAppInterface)
  {
    if ((this.dSY <= 0) && (this.dSX <= 0))
    {
      this.dSZ = -1;
      return;
    }
    this.HE.clear();
    this.HF.clear();
    this.nz.clear();
    this.aqR = 0L;
    this.dSY = 0;
    Object localObject1 = ((TroopManager)paramQQAppInterface.getManager(52)).cE();
    try
    {
      long l = Long.valueOf(this.sessionInfo.aTl).longValue();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Entity)((Iterator)localObject1).next();
        if ((localObject2 instanceof TroopInfo))
        {
          localObject2 = (TroopInfo)localObject2;
          if (((TroopInfo)localObject2).associatePubAccount == l)
          {
            this.dSY += 1;
            this.HE.add(localObject2);
            if (paramQQAppInterface.cs(((TroopInfo)localObject2).troopuin) == 3) {
              this.HF.add(((TroopInfo)localObject2).troopuin);
            }
            this.nz.put(((TroopInfo)localObject2).troopuin, Integer.valueOf(paramQQAppInterface.a().A(((TroopInfo)localObject2).troopuin, 1)));
          }
        }
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.d(".troop.troop_pubaccount", 2, "publicAccount uin format exception. sessionInfo.curFriendUin is not long. value is " + this.sessionInfo.aTl);
      dYB();
      dYC();
      paramQQAppInterface.a().iY(this.HF);
    }
  }
  
  public void onClick(View paramView)
  {
    ThreadManager.post(new TroopEntranceBar.2(this), 8, null, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void unInit()
  {
    deleteObservers();
    this.app.removeObserver(this.jdField_c_of_type_Acfd);
    this.app = null;
    this.context = null;
    this.sessionInfo = null;
    this.fs = null;
    this.a = null;
    this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.j = null;
  }
  
  static final class a
    extends acfd
  {
    WeakReference<apbk> hZ;
    
    private a(apbk paramapbk)
    {
      this.hZ = new WeakReference(paramapbk);
    }
    
    protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
    {
      apbk localapbk = (apbk)this.hZ.get();
      if ((localapbk != null) && (paramBoolean) && (paramString != null) && (localapbk.HE != null) && (localapbk.HE.size() > 0) && (paramString.equals(((TroopInfo)localapbk.HE.get(0)).troopuin))) {
        localapbk.dYA();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbk
 * JD-Core Version:    0.7.0.1
 */