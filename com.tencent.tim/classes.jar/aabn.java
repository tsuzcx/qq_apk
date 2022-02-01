import Wallet.SkinInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.plugin.QwAdapter;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class aabn
{
  private static final String bco = acfp.m(2131707114);
  private aabl jdField_a_of_type_Aabl = aabl.a.a(bco);
  private IRedPacket.OnGetSkinListener jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener = new aabp(this);
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  private acgn jdField_b_of_type_Acgn;
  private SendHbActivity jdField_b_of_type_ComTencentMobileqqActivityQwalletSendHbActivity;
  private boolean buX;
  private int cga = -1;
  private boolean cj;
  private BusinessObserver d = new aabo(this);
  private AdapterView.OnItemClickListener g = new aabq(this);
  private List<LinearLayout> holders = new ArrayList();
  private int skin_id = -1;
  private List<aabl> vb = new ArrayList();
  List<aabn.b> vc = new ArrayList();
  
  public aabn(SendHbActivity paramSendHbActivity)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletSendHbActivity = paramSendHbActivity;
    init();
  }
  
  private boolean We()
  {
    if (this.jdField_b_of_type_Acgn != null) {
      return this.jdField_b_of_type_Acgn.aas();
    }
    return false;
  }
  
  private void hv(List<aabl> paramList)
  {
    paramList.add(aabl.a.b(bco));
    if ((We()) && (!paramList.contains(this.jdField_a_of_type_Aabl)))
    {
      QLog.d("HbSkinLogic", 2, "add vip info to list!");
      paramList.add(this.jdField_a_of_type_Aabl);
    }
  }
  
  private void hw(List<aabl> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SkinInfo localSkinInfo = ((aabl)paramList.next()).a;
      RedPacketInfoBase localRedPacketInfoBase = new RedPacketInfoBase();
      localRedPacketInfoBase.skinType = 1;
      localRedPacketInfoBase.skinId = localSkinInfo.skin_id;
      localRedPacketInfoBase.isCache = aabl.buW;
      RedPacketManager.getInstance().getSkin(localRedPacketInfoBase, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketIRedPacket$OnGetSkinListener);
    }
  }
  
  private void init()
  {
    ArrayList localArrayList = new ArrayList();
    hv(localArrayList);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter = new QwAdapter(this.jdField_b_of_type_ComTencentMobileqqActivityQwalletSendHbActivity, localArrayList, 2131560674, new aabn.a());
    this.jdField_b_of_type_Acgn = ((acgn)this.jdField_b_of_type_ComTencentMobileqqActivityQwalletSendHbActivity.getAppRuntime().getManager(131));
    RedPacketManager.getInstance().registRedPacketSkinListObserver(this.d);
    ApngImage.playByTag(0);
  }
  
  public void FP(int paramInt)
  {
    Iterator localIterator = this.holders.iterator();
    while (localIterator.hasNext()) {
      ((ViewGroup)((LinearLayout)localIterator.next()).getParent()).setVisibility(paramInt);
    }
  }
  
  public boolean Wf()
  {
    return this.buX;
  }
  
  public void ctE()
  {
    int i = yy();
    QLog.i("HbSkinLogic", 2, "set select skin: " + i);
    if (this.cga != i)
    {
      QLog.i("HbSkinLogic", 2, "set select skin id : " + i + " serverSkinId = " + this.cga);
      RedPacketManager.getInstance().setSelectedSkin(i, this.d);
    }
    if (-2 != i)
    {
      QLog.i("HbSkinLogic", 2, "clear vip info...");
      if (this.jdField_b_of_type_Acgn != null) {
        this.jdField_b_of_type_Acgn.x(0, 0, true);
      }
    }
  }
  
  public void destroyView(View paramView)
  {
    this.holders.remove(paramView);
  }
  
  public void onDestroy()
  {
    QLog.i("HbSkinLogic", 2, "onDestroy called...");
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletSendHbActivity = null;
    this.holders.clear();
    this.vc.clear();
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList().clear();
    RedPacketManager.getInstance().unregistRedPacketSkinListObserver(this.d);
  }
  
  public void onResume()
  {
    List localList = this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList();
    QLog.d("HbSkinLogic", 2, "is vip: " + We());
    if (We()) {
      if (!localList.contains(this.jdField_a_of_type_Aabl))
      {
        QLog.d("HbSkinLogic", 2, "add vip info to list!");
        localList.add(this.jdField_a_of_type_Aabl);
        aabl.cfZ = this.jdField_a_of_type_Aabl.a.skin_id;
        aabl.hu(localList);
        this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
      }
    }
    while (!localList.contains(this.jdField_a_of_type_Aabl)) {
      return;
    }
    QLog.d("HbSkinLogic", 2, "remove vip info to list!");
    localList.remove(this.jdField_a_of_type_Aabl);
    aabl.cfZ = 0;
    aabl.hu(localList);
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
  }
  
  public int yy()
  {
    return aabl.p(this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getList());
  }
  
  public class a
    implements QwAdapter.IViewHolder<aabl>
  {
    private TextView NP;
    private TextView NQ;
    private AnimationView e;
    private Resources mResources;
    private ImageView vS;
    private ImageView vT;
    private ImageView vU;
    private View zo;
    private View zp;
    private View zq;
    
    public a() {}
    
    public void a(int paramInt, View paramView, aabl paramaabl)
    {
      int i = 8;
      QLog.d("HbSkinLogic", 2, "setItemView info = " + paramaabl);
      Object localObject;
      if (aabl.cfZ == paramaabl.jdField_a_of_type_WalletSkinInfo.skin_id)
      {
        localObject = aabn.this.vc.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((aabn.b)((Iterator)localObject).next()).a(paramaabl);
        }
      }
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      zxd.a(this.e, false);
      if (1 == paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.isHideTitle)
      {
        this.NQ.setText("");
        paramView = this.zo;
        if (1 != paramaabl.cfY) {
          break label372;
        }
        paramInt = 8;
        label139:
        paramView.setVisibility(paramInt);
        paramView = this.zp;
        if (1 != paramaabl.cfY) {
          break label377;
        }
        paramInt = 0;
        label159:
        paramView.setVisibility(paramInt);
        this.NP.setText(paramaabl.name);
        paramView = this.zq;
        if (aabl.cfZ != paramaabl.jdField_a_of_type_WalletSkinInfo.skin_id) {
          break label383;
        }
        paramInt = i;
        label196:
        paramView.setVisibility(paramInt);
        paramView = this.NP;
        if (aabl.cfZ != paramaabl.jdField_a_of_type_WalletSkinInfo.skin_id) {
          break label388;
        }
        paramInt = -16777216;
        label222:
        paramView.setTextColor(paramInt);
        localObject = this.vU;
        if (paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon != null) {
          break label394;
        }
        paramView = this.mResources.getDrawable(2130848111);
        label253:
        ((ImageView)localObject).setBackgroundDrawable(paramView);
        if (-1 != paramaabl.cfY) {
          break label412;
        }
        this.vS.setImageResource(2130844341);
        this.vS.setBackgroundDrawable(this.mResources.getDrawable(2130844335));
        label292:
        localObject = this.vT;
        if (paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner == null) {
          break label566;
        }
      }
      label388:
      label394:
      label412:
      label566:
      for (paramView = paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.corner;; paramView = null)
      {
        for (;;)
        {
          ((ImageView)localObject).setImageBitmap(paramView);
          return;
          localObject = this.NQ;
          if (TextUtils.isEmpty(paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title)) {}
          for (paramView = paramView.getContext().getString(2131699043);; paramView = paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title)
          {
            ((TextView)localObject).setText(paramView);
            break;
          }
          label372:
          paramInt = 0;
          break label139;
          label377:
          paramInt = 8;
          break label159;
          label383:
          paramInt = 0;
          break label196;
          paramInt = -7829368;
          break label222;
          paramView = new BitmapDrawable(paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.icon);
          break label253;
          if (-2 == paramaabl.cfY)
          {
            this.vS.setImageResource(2130844341);
            this.vS.setBackgroundDrawable(this.mResources.getDrawable(2130844335));
            this.e.setImageResource(2130844343);
            break label292;
          }
          if (!TextUtils.isEmpty(paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.resPath))
          {
            this.vS.setImageBitmap(null);
            paramView = QWalletPicHelper.getDrawableForAIO(new File(paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.resPath, "base_bg.png").toString(), aabn.a(aabn.this).getResources().getDrawable(2130844335));
            this.vS.setBackgroundDrawable(paramView);
          }
          if (paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo == null) {
            break label292;
          }
          try
          {
            new zxd(this.e, 0, false, null).b(paramaabl.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.animInfo);
          }
          catch (OutOfMemoryError paramView) {}
        }
        break label292;
      }
    }
    
    public QwAdapter.IViewHolder clone()
      throws CloneNotSupportedException
    {
      return (QwAdapter.IViewHolder)super.clone();
    }
    
    public View initView(int paramInt, View paramView)
    {
      this.mResources = paramView.getContext().getResources();
      this.zq = paramView.findViewById(2131371272);
      this.zo = paramView.findViewById(2131378462);
      this.zp = paramView.findViewById(2131378463);
      this.vT = ((ImageView)paramView.findViewById(2131368343));
      this.vU = ((ImageView)paramView.findViewById(2131368347));
      this.vS = ((ImageView)paramView.findViewById(2131368344));
      this.vS.setScaleType(ImageView.ScaleType.FIT_START);
      this.NP = ((TextView)paramView.findViewById(2131368345));
      this.NQ = ((TextView)paramView.findViewById(2131368348));
      this.e = ((AnimationView)paramView.findViewById(2131368346));
      return paramView;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(aabl paramaabl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabn
 * JD-Core Version:    0.7.0.1
 */