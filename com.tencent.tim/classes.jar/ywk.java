import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ywk
  extends auvp
{
  private static HashMap<Long, MessageRecord> hf = new HashMap();
  private static HashMap<Long, MessageRecord> hg = new HashMap();
  TextView Mb;
  protected aprf a;
  private yru a;
  protected BaseTroopView.a b;
  private boolean bpl;
  private boolean bpm;
  private boolean bpn;
  private boolean bpo;
  public boolean bpp;
  public boolean bpq;
  protected boolean bpr;
  public boolean bps;
  private boolean bpt;
  private final int cbA = 1;
  private final int cbB = 2;
  private final int cbC = 3;
  private final int cbD = 4;
  private final int cbE = 5;
  private final int cbF = 6;
  private final int cbz = 0;
  private Context context;
  private View.OnClickListener er = new ywm(this);
  private View.OnClickListener es = new ywn(this);
  private View.OnClickListener et = new ywo(this);
  HashMap<String, String> hh;
  private QQAppInterface k;
  protected List<RecommendTroopItem> kO = new ArrayList();
  AppInterface mApp;
  private LayoutInflater mLayoutInflater;
  public List<MessageRecord> tu = new ArrayList();
  protected List<MessageRecord> tv = new ArrayList();
  public int unreadMsgNum;
  protected View yn;
  View yo;
  
  public ywk(QQAppInterface paramQQAppInterface, Context paramContext, BaseTroopView.a parama, yru paramyru)
  {
    this.k = paramQQAppInterface;
    this.mApp = paramQQAppInterface;
    this.context = paramContext;
    this.b = parama;
    this.mLayoutInflater = LayoutInflater.from(this.context);
    this.jdField_a_of_type_Yru = paramyru;
    this.bpt = false;
  }
  
  private void d(RecommendTroopItem paramRecommendTroopItem)
  {
    if ((paramRecommendTroopItem == null) || (TextUtils.isEmpty(paramRecommendTroopItem.uin))) {
      QLog.e("TroopReportor.recommend", 1, "notify reportTroopExposure, troopUin == null or troopUin is empty!");
    }
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        str1 = paramRecommendTroopItem.uin;
        str2 = paramRecommendTroopItem.name;
        paramRecommendTroopItem = paramRecommendTroopItem.recomAlgol;
        if (this.hh == null) {
          this.hh = new HashMap();
        }
      } while (this.hh.containsKey(str1));
      this.hh.put(str1, paramRecommendTroopItem);
      aqfr.b("Grp_contacts_news", "notice", "recom_exp_grp", 0, 0, new String[] { str1, paramRecommendTroopItem });
    } while (!QLog.isColorLevel());
    QLog.d("TroopReportor.recommend", 2, String.format("notify reportTroopExposure, troopUin: %s, troopName: %s, recomAlgol:%s", new Object[] { str1, str2, paramRecommendTroopItem }));
  }
  
  private int xM()
  {
    int i = 5;
    this.bpn = false;
    if (this.tv == null) {
      return 0;
    }
    int j = this.tv.size();
    if (j == 0)
    {
      if (this.bpm)
      {
        this.bpn = true;
        this.bpl = true;
        return 2;
      }
      this.bpn = false;
      this.bpl = false;
      return 1;
    }
    if (((this.kO == null) || (this.kO.size() == 0)) && (this.bpq))
    {
      this.bpp = true;
      return this.tv.size();
    }
    if (this.bpt)
    {
      this.bpp = true;
      return this.tv.size();
    }
    if ((this.bps) && (j >= 5)) {}
    while (i < j)
    {
      this.bpl = true;
      return i + 1;
      if (this.unreadMsgNum >= 5) {
        this.bps = true;
      } else if (j >= 3) {
        i = 3;
      } else {
        i = j;
      }
    }
    if (this.bpm)
    {
      this.bpn = true;
      this.bpl = true;
      return j + 1;
    }
    this.bpl = false;
    return j;
  }
  
  public boolean UJ()
  {
    return (this.kO != null) && (this.kO.size() > 0);
  }
  
  public void a(ackn paramackn)
  {
    ArrayList localArrayList;
    int i;
    Object localObject;
    if ((this.tv != null) && (paramackn != null))
    {
      localArrayList = new ArrayList(3);
      Iterator localIterator = this.tv.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localObject = (MessageRecord)localIterator.next();
        if (i < 3) {
          break label70;
        }
      }
      if (paramackn != null) {
        paramackn.dK(localArrayList);
      }
    }
    return;
    label70:
    if ((localObject instanceof MessageForSystemMsg))
    {
      localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
      oidb_0x935.NotifyInfo localNotifyInfo = new oidb_0x935.NotifyInfo();
      localNotifyInfo.uint64_notify_gc.set(((structmsg.StructMsg)localObject).msg.group_code.get());
      localNotifyInfo.uint32_notify_type.set(((structmsg.StructMsg)localObject).msg.group_msg_type.get());
      localArrayList.add(localNotifyInfo);
      i += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public MessageRecord b(int paramInt)
  {
    if ((this.tv != null) && (paramInt >= 0) && (paramInt < this.tv.size())) {
      return (MessageRecord)this.tv.get(paramInt);
    }
    return null;
  }
  
  public void cmw()
  {
    if (this.tv != null) {
      this.tv.clear();
    }
  }
  
  public void cmx()
  {
    Iterator localIterator = hg.keySet().iterator();
    long l;
    Object localObject;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)hg.get(Long.valueOf(l));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          anot.a(this.k, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 2, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
    localIterator = hf.keySet().iterator();
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      localObject = (MessageRecord)hf.get(Long.valueOf(l));
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg)))
      {
        localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
        if ((((structmsg.StructMsg)localObject).msg_seq.has()) && (((structmsg.StructMsg)localObject).msg.group_code.has()) && (((structmsg.StructMsg)localObject).msg.group_msg_type.has())) {
          anot.a(this.k, "dc00899", "Grp_contacts_news", "", "notice", "todotab_notice_exp", 1, 0, String.valueOf(((structmsg.StructMsg)localObject).msg_seq.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_code.get()), String.valueOf(((structmsg.StructMsg)localObject).msg.group_msg_type.get()), "");
        }
      }
    }
  }
  
  public void fW(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (i < paramInt1)
    {
      if (getItemViewType(i) != 0) {}
      for (;;)
      {
        i += 1;
        break;
        MessageRecord localMessageRecord = b(i);
        if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForSystemMsg)))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg.msg_seq.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.has()) && (((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get() == 1) && (localStructMsg.msg.group_msg_type.has())) {
            if ((paramInt2 == 1) && (!hf.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              hf.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            } else if ((paramInt2 == 0) && (!hg.containsKey(Long.valueOf(localStructMsg.msg_seq.get())))) {
              hg.put(Long.valueOf(localStructMsg.msg_seq.get()), localMessageRecord);
            }
          }
        }
      }
    }
  }
  
  public void g(LinearLayout paramLinearLayout)
  {
    Object localObject = this.context.getResources();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = wja.dp2px(238.0F, (Resources)localObject);
    localURLDrawableOptions.mRequestHeight = wja.dp2px(161.0F, (Resources)localObject);
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20180622/1bf451e30af44c7c8f49ef5dd5a25822.png", localURLDrawableOptions);
    ((ImageView)paramLinearLayout.findViewById(2131368460)).setImageDrawable((Drawable)localObject);
  }
  
  public void gR(List<MessageRecord> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.d("NotifyAndRecAdapter", 2, "noti size is " + paramList.size());
    }
    if ((paramList == null) || (this.tv == null)) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      this.tv.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
          {
            localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
            this.tv.add(localMessageRecord);
          }
        }
      }
    }
  }
  
  public void gS(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "setRecData: " + paramList);
    }
    this.kO = paramList;
  }
  
  public int getCount()
  {
    int i = xM();
    int j = xO();
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "total count is" + i + "," + j);
    }
    return i + j;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.tv == null) {
      return 3;
    }
    int i = this.tv.size();
    if (((this.kO == null) || (this.kO.size() == 0)) && (this.bpq)) {}
    for (this.bpp = true;; this.bpp = false)
    {
      if (i != 0) {
        break label85;
      }
      if (paramInt == 0) {
        break;
      }
      if ((paramInt != xM() - 1) || (!this.bpl)) {
        break label85;
      }
      return 2;
    }
    label85:
    if (this.bpp) {
      return 0;
    }
    i = xM();
    if (paramInt == i) {
      return 6;
    }
    if ((paramInt == i - 1) && (this.bpl)) {
      return 2;
    }
    if ((paramInt == i + 1) && (this.bpo)) {
      return 4;
    }
    if (paramInt <= i - 1) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (i == 1)
    {
      i = paramInt - xM() - 1;
      if ((i < 0) || (i >= this.kO.size()))
      {
        localObject2 = paramView;
        localObject1 = paramView;
        paramView = (View)localObject2;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject1;
      }
      localObject3 = (RecommendTroopItem)this.kO.get(i);
      if ((this.k != null) && ((this.k instanceof QQAppInterface))) {
        localObject2 = aqdj.a(this.k, 4, ((RecommendTroopItem)localObject3).uin);
      }
    }
    for (;;)
    {
      if (paramView != null)
      {
        localObject1 = paramView;
        if ((paramView.getTag() instanceof yvb.a)) {}
      }
      else
      {
        localObject1 = yvb.a(this.context, this.es, this.er, this.et);
      }
      yvb.a((yvb.a)((View)localObject1).getTag(), (RecommendTroopItem)localObject3, (Drawable)localObject2);
      d((RecommendTroopItem)localObject3);
      paramView = (View)localObject1;
      break;
      if (this.jdField_a_of_type_Aprf != null)
      {
        localObject1 = this.jdField_a_of_type_Aprf.getFaceBitmap(((RecommendTroopItem)localObject3).uin, true);
        if (localObject1 != null)
        {
          localObject2 = new BitmapDrawable((Bitmap)localObject1);
          continue;
          if (i == 0)
          {
            localObject1 = n(paramInt, paramView, paramViewGroup);
            break;
          }
          if (i == 2)
          {
            anot.a(this.k, "dc00899", "Grp_contacts_news", "", "notice", "verify_exp", 0, 0, "", "", "", "");
            localObject2 = LayoutInflater.from(this.context).inflate(2131563278, null);
            localObject3 = (TextView)((View)localObject2).findViewById(2131377913);
            localObject1 = null;
            if (this.bpn) {}
            for (;;)
            {
              ((TextView)localObject3).setText((CharSequence)localObject1);
              if (this.bpt) {
                ((View)localObject2).setVisibility(8);
              }
              ((View)localObject2).setOnClickListener(new ywl(this, (View)localObject2));
              if (!this.bpr)
              {
                aqfr.b("Grp_contacts_news", "notice", "verify_clk", 2, 0, new String[0]);
                this.bpr = true;
              }
              localObject1 = localObject2;
              break;
              if (this.unreadMsgNum > xM() - 2) {
                localObject1 = acfp.m(2131709165) + this.unreadMsgNum + acfp.m(2131709167);
              } else {
                localObject1 = acfp.m(2131709164);
              }
            }
          }
          if (i == 4)
          {
            i = this.context.getSharedPreferences("nearby_troop_count", 0).getInt("troop_num", 0);
            this.yn = LayoutInflater.from(this.context).inflate(2131560855, null);
            this.Mb = ((TextView)this.yn.findViewById(2131372252));
            this.yo = this.yn.findViewById(2131372238);
            if (i != 0)
            {
              localObject1 = this.context.getSharedPreferences("nearby_troop_count", 0).getString("troop_wording", "");
              this.Mb.setText((CharSequence)localObject1);
            }
            for (;;)
            {
              localObject1 = this.yn;
              break;
              this.yo.setVisibility(8);
              this.yn.setPadding(0, 0, 0, 0);
            }
          }
          if (i == 5)
          {
            localObject1 = LayoutInflater.from(this.context).inflate(2131563279, null);
            ((TextView)((View)localObject1).findViewById(2131368472)).setText(acfp.m(2131709163));
            ((LinearLayout)((View)localObject1).findViewById(2131372517)).setVisibility(8);
            break;
          }
          if (i == 6)
          {
            localObject1 = LayoutInflater.from(this.context).inflate(2131563279, null);
            ((TextView)((View)localObject1).findViewById(2131368472)).setText(acfp.m(2131709162));
            ((LinearLayout)((View)localObject1).findViewById(2131372517)).setVisibility(8);
            break;
          }
          if (i == 3)
          {
            localObject1 = LayoutInflater.from(this.context).inflate(2131563279, null);
            localObject2 = (TextView)((View)localObject1).findViewById(2131368472);
            ((TextView)localObject2).setText(acfp.m(2131709166));
            ((TextView)localObject2).setVisibility(8);
            localObject2 = (LinearLayout)((View)localObject1).findViewById(2131372517);
            ((LinearLayout)localObject2).setVisibility(0);
            g((LinearLayout)localObject2);
            break;
          }
          localObject1 = null;
          break;
        }
      }
      localObject2 = null;
    }
  }
  
  public boolean isShowAll()
  {
    return this.bpt;
  }
  
  public View n(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ywa.a)))
    {
      paramView = this.mLayoutInflater.inflate(2131560104, paramViewGroup, false);
      paramViewGroup = new ywa.a();
      paramViewGroup.hC = ((LinearLayout)paramView.findViewById(2131374288));
      paramViewGroup.uw = ((ImageView)paramView.findViewById(2131374278));
      paramViewGroup.hD = ((LinearLayout)paramView.findViewById(2131374285));
      paramViewGroup.uF = ((ImageView)paramView.findViewById(2131374292));
      paramViewGroup.LW = ((TextView)paramView.findViewById(2131374283));
      paramViewGroup.LX = ((TextView)paramView.findViewById(2131374289));
      paramViewGroup.LY = ((TextView)paramView.findViewById(2131374291));
      paramViewGroup.LZ = ((TextView)paramView.findViewById(2131374284));
      paramViewGroup.ej = ((Button)paramView.findViewById(2131374287));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131380367));
      localObject = (Button)paramView.findViewById(2131380366);
      paramView.setTag(paramViewGroup);
      paramViewGroup.mPosition = paramInt;
      ysa.C(paramViewGroup.hC, false);
      localObject = b(paramInt);
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg))) {
        break label238;
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (ywa.a)paramView.getTag();
      break;
      label238:
      paramViewGroup.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localObject).getSystemMsg();
      paramViewGroup.uniseq = ((MessageRecord)localObject).uniseq;
      if (localObject != null) {}
      for (int i = ((MessageForSystemMsg)localObject).getSystemMsg().msg_type.get(); i == 2; i = 2)
      {
        this.jdField_a_of_type_Yru.a(paramViewGroup, paramInt);
        return paramView;
      }
    }
  }
  
  public int xN()
  {
    if ((this.bpl) && (!this.bpt)) {
      return xM() - 1;
    }
    return xM();
  }
  
  public int xO()
  {
    int j = this.kO.size();
    int i = j;
    if (this.bpo) {
      i = j + 1;
    }
    return i;
  }
  
  public void zm(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    RecommendTroopItem localRecommendTroopItem;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.kO == null) || (this.kO.size() <= 0)) {}
        localIterator = this.kO.iterator();
      } while (!localIterator.hasNext());
      localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
    } while (!paramString.equals(localRecommendTroopItem.uin));
    localRecommendTroopItem.hasRequestJoin = true;
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "updateJoinStatus, troopUin: " + paramString);
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywk
 * JD-Core Version:    0.7.0.1
 */