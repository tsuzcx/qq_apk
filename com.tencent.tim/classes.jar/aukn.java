import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.UinRightInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aukn
  extends auvp
{
  int dNM;
  View.OnClickListener fQ;
  QQAppInterface mApp;
  Map<String, aukn.b> mCache = new HashMap();
  Context mContext;
  List<aukn.b> uK;
  
  public aukn(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<aukn.b> paramList)
  {
    this.mApp = paramQQAppInterface;
    this.uK = paramList;
    this.mContext = paramContext;
    this.fQ = paramOnClickListener;
  }
  
  public void RG(String paramString)
  {
    aukn.b localb = (aukn.b)this.mCache.get(paramString);
    if (localb == null) {
      return;
    }
    localb.nickName = nO(paramString);
    notifyDataSetChanged();
  }
  
  public void RH(String paramString)
  {
    paramString = (aukn.b)this.mCache.remove(paramString);
    this.uK.remove(paramString);
  }
  
  public void VF(int paramInt)
  {
    this.dNM = paramInt;
  }
  
  public void a(aukn.b paramb)
  {
    if (paramb == null) {
      return;
    }
    this.uK.add(0, paramb);
    this.mCache.put(paramb.uin, paramb);
  }
  
  public int getCount()
  {
    return this.uK.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.uK.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    label116:
    Object localObject;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131563162, null);
      paramView = new aukn.a();
      paramView.bO = ((URLImageView)localView.findViewById(2131368483));
      paramView.xR = ((TextView)localView.findViewById(2131372361));
      paramView.Gb = ((TextView)localView.findViewById(2131378717));
      paramView.gX = ((ImageView)localView.findViewById(2131362995));
      localView.setTag(paramView);
      if (this.dNM != 2) {
        break label262;
      }
      paramView.Gb.setVisibility(8);
      paramView.gX.setVisibility(8);
      localObject = (aukn.b)getItem(paramInt);
      String str = String.valueOf(((aukn.b)localObject).c.uint64_uin.get());
      aqdj localaqdj = aqdj.a(this.mApp, 1, str);
      paramView.bO.setImageDrawable(localaqdj);
      str = nO(str);
      paramView.xR.setText(str);
      i = ((aukn.b)localObject).c.uint32_right.get();
      if (i != 1) {
        break label281;
      }
      paramView.Gb.setText(2131720872);
    }
    for (;;)
    {
      paramView.b = ((aukn.b)localObject).c;
      localView.setOnClickListener(this.fQ);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aukn.a)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label262:
      paramView.Gb.setVisibility(0);
      paramView.gX.setVisibility(0);
      break label116;
      label281:
      if (i == 2) {
        paramView.Gb.setText(2131720873);
      } else {
        paramView.Gb.setText("状态错了，需要检查！");
      }
    }
  }
  
  public String nO(String paramString)
  {
    Object localObject = (aukn.b)this.mCache.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = aqgv.b(this.mApp, ((aukn.b)localObject).uin, ((aukn.b)localObject).cjm, ((aukn.b)localObject).uinType);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((aukn.b)this.mCache.get(paramString)).nickName = ((String)localObject);
    }
    return ((aukn.b)this.mCache.get(paramString)).nickName;
  }
  
  public class a
  {
    public TextView Gb;
    TimDocSSOMsg.UinRightInfo jdField_b_of_type_ComTencentTimSsoCmdTimDocSSOMsg$UinRightInfo;
    public URLImageView bO;
    public ImageView gX;
    public TextView xR;
    
    public a() {}
  }
  
  public static class b
  {
    public TimDocSSOMsg.UinRightInfo c;
    public String cjm;
    public String nickName;
    public String uin;
    public int uinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aukn
 * JD-Core Version:    0.7.0.1
 */