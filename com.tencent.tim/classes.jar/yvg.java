import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;

public abstract class yvg
{
  protected TextView LV;
  protected ackn a;
  protected yvg.a a;
  private acnd b;
  public yvb b;
  public boolean bpf = true;
  protected boolean bpg = true;
  protected boolean bph = true;
  private AbsListView.e c = new yvh(this);
  protected QQAppInterface mApp;
  protected Context mContext;
  protected XListView mListView;
  
  public yvg()
  {
    this.jdField_b_of_type_Acnd = new yvi(this);
  }
  
  public yvg(QQAppInterface paramQQAppInterface, Context paramContext, XListView paramXListView, yvg.a parama)
  {
    this.jdField_b_of_type_Acnd = new yvi(this);
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mListView = paramXListView;
    this.jdField_a_of_type_Yvg$a = parama;
    init();
  }
  
  private void cmg()
  {
    this.LV = new TextView(this.mContext);
    this.LV.setText(acfp.m(2131713759));
    this.LV.setGravity(17);
    this.LV.setTextSize(1, 14.0F);
    int i = wja.dp2px(10.0F, this.mContext.getResources());
    this.LV.setPadding(i, i, i, i);
    this.LV.setTextColor(this.mContext.getResources().getColor(2131167383));
    this.mListView.addFooterView(this.LV);
    this.LV.setVisibility(4);
  }
  
  private void cmi()
  {
    ckE();
    this.LV.setVisibility(0);
    if (Uf()) {
      this.LV.setText(acfp.m(2131713760));
    }
  }
  
  private void initAdapter()
  {
    cmg();
    this.jdField_b_of_type_Yvb = a();
    this.jdField_b_of_type_Yvb.bF(null);
    this.mListView.setAdapter(this.jdField_b_of_type_Yvb);
    this.mListView.setDividerHeight(0);
    if (this.bph) {
      this.mListView.setOnScrollListener(this.c);
    }
  }
  
  protected void As(boolean paramBoolean)
  {
    if (paramBoolean) {
      cmi();
    }
  }
  
  protected void At(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ackn.a(this.mApp.getLongAccountUin(), a(), 21);
  }
  
  protected boolean Uf()
  {
    return this.jdField_a_of_type_Ackn.isEnd == 1;
  }
  
  public XListView a()
  {
    return this.mListView;
  }
  
  protected oidb_0x935.GPS a()
  {
    Object localObject = aczc.a("recommend_troop");
    double d1;
    int k;
    double d2;
    String str;
    int i;
    if (localObject != null)
    {
      d1 = ((SosoInterface.SosoLbsInfo)localObject).a.altitude;
      k = (int)((SosoInterface.SosoLbsInfo)localObject).a.accuracy;
      d2 = ((SosoInterface.SosoLbsInfo)localObject).a.RJ;
      str = ((SosoInterface.SosoLbsInfo)localObject).a.cityCode;
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(str);
      i = j;
    }
    catch (Exception localException)
    {
      label66:
      double d3;
      double d4;
      break label66;
    }
    d3 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.cd * 1000000.0D).intValue();
    d4 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.ce * 1000000.0D).intValue();
    localObject = new oidb_0x935.GPS();
    ((oidb_0x935.GPS)localObject).uint32_latitude.set((int)d3);
    ((oidb_0x935.GPS)localObject).uint32_longitude.set((int)d4);
    ((oidb_0x935.GPS)localObject).uint32_altitude.set((int)d1);
    ((oidb_0x935.GPS)localObject).uint32_accuracy.set(k);
    ((oidb_0x935.GPS)localObject).uint32_time.set((int)d2);
    ((oidb_0x935.GPS)localObject).uint32_cityid.set(i);
    ((oidb_0x935.GPS)localObject).bytes_client_version.set(ByteStringMicro.copyFromUtf8("3.4.4"));
    ((oidb_0x935.GPS)localObject).uint32_client.set(2);
    return localObject;
    return null;
  }
  
  protected abstract yvb a();
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected void ckE()
  {
    this.jdField_b_of_type_Yvb.bF(this.jdField_a_of_type_Ackn.xR);
    this.jdField_b_of_type_Yvb.notifyDataSetChanged();
  }
  
  public void cmh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopListWrapper", 2, "checkAndLoadMoreRecommList isEnd = " + Uf());
    }
    if (!Uf()) {
      At(true);
    }
  }
  
  protected void init()
  {
    if (this.mListView == null) {
      this.mListView = new XListView(this.mContext);
    }
    this.jdField_a_of_type_Ackn = ((ackn)this.mApp.getManager(22));
    initAdapter();
    this.mApp.addObserver(this.jdField_b_of_type_Acnd);
    if ((this.bpf) && (this.bpg)) {
      At(false);
    }
  }
  
  public void onDetach()
  {
    this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
  }
  
  public void refresh()
  {
    At(false);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvg
 * JD-Core Version:    0.7.0.1
 */