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
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class aoae
  extends auvp
{
  int dNM;
  View.OnClickListener fQ;
  QQAppInterface mApp;
  Map<String, aoae.b> mCache = new HashMap();
  Context mContext;
  List<aoae.b> uK;
  
  public aoae(QQAppInterface paramQQAppInterface, Context paramContext, View.OnClickListener paramOnClickListener, List<aoae.b> paramList)
  {
    this.mApp = paramQQAppInterface;
    this.uK = paramList;
    this.mContext = paramContext;
    this.fQ = paramOnClickListener;
  }
  
  public void RG(String paramString)
  {
    aoae.b localb = (aoae.b)this.mCache.get(paramString);
    if (localb == null) {
      return;
    }
    localb.nickName = nO(paramString);
    notifyDataSetChanged();
  }
  
  public void RH(String paramString)
  {
    paramString = (aoae.b)this.mCache.remove(paramString);
    this.uK.remove(paramString);
  }
  
  public void VF(int paramInt)
  {
    this.dNM = paramInt;
  }
  
  public void a(aoae.b paramb)
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
      paramView = new aoae.a();
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
      localObject = (aoae.b)getItem(paramInt);
      String str = String.valueOf(((aoae.b)localObject).b.uint64_uin.get());
      aqdj localaqdj = aqdj.a(this.mApp, 1, str);
      paramView.bO.setImageDrawable(localaqdj);
      str = nO(str);
      paramView.xR.setText(str);
      i = ((aoae.b)localObject).b.uint32_right.get();
      if (i != 1) {
        break label281;
      }
      paramView.Gb.setText(2131720872);
    }
    for (;;)
    {
      paramView.a = ((aoae.b)localObject).b;
      localView.setOnClickListener(this.fQ);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aoae.a)paramView.getTag();
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
        paramView.Gb.setText(acfp.m(2131715175));
      }
    }
  }
  
  public String nO(String paramString)
  {
    Object localObject = (aoae.b)this.mCache.get(paramString);
    if (localObject == null) {
      return paramString;
    }
    localObject = aqgv.b(this.mApp, ((aoae.b)localObject).uin, ((aoae.b)localObject).cjm, ((aoae.b)localObject).uinType);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      ((aoae.b)this.mCache.get(paramString)).nickName = ((String)localObject);
    }
    return ((aoae.b)this.mCache.get(paramString)).nickName;
  }
  
  public class a
  {
    public TextView Gb;
    public TimDocSSOMsg.UinRightInfo a;
    public URLImageView bO;
    public ImageView gX;
    public TextView xR;
    
    public a() {}
  }
  
  public static class b
  {
    public TimDocSSOMsg.UinRightInfo b;
    public String cjm;
    public String nickName;
    public String uin;
    public int uinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoae
 * JD-Core Version:    0.7.0.1
 */