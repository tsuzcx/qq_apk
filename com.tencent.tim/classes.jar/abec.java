import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class abec
  extends BaseAdapter
  implements aqdf.a, AbsListView.e
{
  protected abec.a a;
  private aqdf a;
  protected boolean bCb;
  QQAppInterface e;
  private View.OnClickListener eL = new abee(this);
  protected View.OnClickListener eo = new abef(this);
  private Context mContext;
  public boolean mIsResume = true;
  private LayoutInflater mLayoutInflater;
  private int mScrollState = 0;
  private ListView r;
  private ArrayList<Object> sC = new ArrayList();
  private List<DiscussionInfo> vR = new ArrayList();
  private List<Entity> vS = new ArrayList();
  
  public abec(Context paramContext, abec.a parama, ListView paramListView, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.e = paramQQAppInterface;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      cBi();
    }
    this.jdField_a_of_type_Aqdf = new aqdf(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Aqdf.a(this);
    this.r = paramListView;
    this.jdField_a_of_type_Abec$a = parama;
    paramListView.setOnScrollListener(this);
  }
  
  private void cBi()
  {
    this.vR = ((acdu)this.e.getManager(53)).getDiscussList();
    Object localObject1 = new HashMap();
    Object localObject2 = this.mContext.getResources().getString(2131721539);
    String str1 = this.mContext.getResources().getString(2131691843);
    Iterator localIterator = this.vR.iterator();
    if (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l = 0L;
      String str2 = aqgv.a(this.mContext, localDiscussionInfo);
      String str3 = ChnToSpell.aJ(str2, 1);
      if ((str2.matches((String)localObject2)) || (str2.contains(str1))) {
        l = 65536L;
      }
      if ((str3 == null) || (str3.length() == 0)) {
        l |= 0xFFFF;
      }
      for (;;)
      {
        ((HashMap)localObject1).put(localDiscussionInfo.uin, Long.valueOf(l));
        break;
        if (aqmr.isAsciiAlpha(str3.charAt(0))) {
          l |= str3.charAt(0);
        } else if (Character.isDigit(str3.charAt(0))) {
          l |= 0xFFFE;
        } else {
          l |= 0xFFFF;
        }
      }
    }
    Collections.sort(this.vR, new abed(this, (HashMap)localObject1));
    this.vS.clear();
    localObject1 = this.vR.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      if (((DiscussionInfo)localObject2).hasCollect) {
        this.vS.add(localObject2);
      }
    }
    this.sC.clear();
    if (this.vR.size() > 0)
    {
      int i = this.vS.size();
      if (i > 0)
      {
        this.sC.add(Integer.valueOf(i));
        this.sC.addAll(this.vS);
      }
      this.sC.add(Integer.valueOf(i));
      this.sC.addAll(this.vR);
    }
  }
  
  private void q(String paramString, Bitmap paramBitmap)
  {
    int j = this.r.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.r.getChildAt(i).getTag();
      if ((localObject == null) || (!(localObject instanceof abec.b))) {
        break label169;
      }
      localObject = (abec.b)localObject;
      if ((paramString == null) && (!TextUtils.isEmpty(((abec.b)localObject).uin)))
      {
        paramBitmap = this.jdField_a_of_type_Aqdf.b(101, ((abec.b)localObject).uin);
        if (paramBitmap != null) {
          ((abec.b)localObject).aL.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
        }
      }
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_Aqdf.i(((abec.b)localObject).uin, 101, true);
      continue;
      if (TextUtils.equals(paramString, ((abec.b)localObject).uin))
      {
        ((abec.b)localObject).aL.setBackgroundDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
        return;
      }
    }
  }
  
  public void Dt(boolean paramBoolean)
  {
    this.bCb = paramBoolean;
  }
  
  public DiscussionInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.sC.size())) {
      return (DiscussionInfo)this.sC.get(paramInt);
    }
    return null;
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_Aqdf.destory();
  }
  
  public int getCount()
  {
    return this.sC.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.sC.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof DiscussionInfo)) {
      return Long.parseLong(((DiscussionInfo)localObject).uin);
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof Integer)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    abec.b localb;
    Object localObject;
    if (getItemViewType(paramInt) == 1) {
      if (paramView == null)
      {
        paramView = this.mLayoutInflater.inflate(2131559250, paramViewGroup, false);
        localb = new abec.b(null);
        localb.aL = ((ImageView)paramView.findViewById(2131368698));
        localb.fe = ((TextView)paramView.findViewById(2131379402));
        localb.Pn = ((TextView)paramView.findViewById(2131379404));
        localb.xk = ((ImageView)paramView.findViewById(2131365953));
        localb.aL.setImageBitmap(null);
        localb.aL.setClickable(false);
        localb.Pn.setVisibility(0);
        paramView.setTag(localb);
        paramView.setOnClickListener(this.eL);
        ((Button)paramView.findViewById(2131365946)).setOnClickListener(this.eo);
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)getItem(paramInt);
        String str = localDiscussionInfo.uin;
        localObject = aqgv.a(this.mContext, localDiscussionInfo);
        localb.fe.setText((CharSequence)localObject);
        localObject = (acdu)this.e.getManager(53);
        localb.Pn.setText(String.format("(%d)", new Object[] { Integer.valueOf(((acdu)localObject).cn(str)) }));
        localObject = this.jdField_a_of_type_Aqdf.b(101, str);
        if (localObject != null) {
          break label344;
        }
        localb.aL.setBackgroundDrawable(aqhu.aX());
        label266:
        if (this.mScrollState == 0) {
          this.jdField_a_of_type_Aqdf.i(str, 101, false);
        }
        localb.uin = str;
        localb.e = localDiscussionInfo;
        if (!this.bCb) {
          break label371;
        }
        localb.xk.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localb = (abec.b)paramView.getTag();
      break;
      label344:
      localb.aL.setBackgroundDrawable(new BitmapDrawable(this.r.getResources(), (Bitmap)localObject));
      break label266;
      label371:
      localb.xk.setVisibility(8);
      continue;
      if (paramView == null)
      {
        localb = new abec.b(null);
        paramView = this.mLayoutInflater.inflate(2131559249, paramViewGroup, false);
        localb.fe = ((TextView)paramView.findViewById(2131365970));
        paramView.setTag(localb);
      }
      for (;;)
      {
        localb.uin = "";
        if ((paramInt != 0) || (this.vS.size() <= 0)) {
          break label482;
        }
        localb.fe.setText(2131696114);
        break;
        localb = (abec.b)paramView.getTag();
      }
      label482:
      localb.fe.setText(2131696103);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void notifyDataSetChanged()
  {
    cBi();
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.mScrollState == 0)) {
      q(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    if (paramInt == 0)
    {
      q(null, null);
      this.jdField_a_of_type_Aqdf.resume();
      return;
    }
    this.jdField_a_of_type_Aqdf.pause();
    this.jdField_a_of_type_Aqdf.edu();
  }
  
  public static abstract interface a
  {
    public abstract void a(DiscussionInfo paramDiscussionInfo);
  }
  
  static class b
  {
    public TextView Pn;
    public ImageView aL;
    public DiscussionInfo e;
    public TextView fe;
    public String uin;
    public ImageView xk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abec
 * JD-Core Version:    0.7.0.1
 */