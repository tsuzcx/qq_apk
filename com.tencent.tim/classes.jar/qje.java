import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tribe.async.dispatch.Dispatcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class qje
  extends qjb
{
  public final int MAX_COUNT;
  public qji a;
  protected ConcurrentHashMap<String, Boolean> cf = new ConcurrentHashMap();
  public ArrayList<WeakReference<qjg>> nb = new ArrayList();
  
  public qje(qji paramqji)
  {
    super(paramqji);
    this.a = paramqji;
    paramqji = this.a.a().mBundle.getStringArrayList("EXTRA_VIDEO_ID_LIST");
    this.MAX_COUNT = this.a.a().mBundle.getInt("EXTRA_INT_MAX_SELECT_COUNT", 10);
    if (paramqji != null)
    {
      paramqji = paramqji.iterator();
      while (paramqji.hasNext())
      {
        String str = (String)paramqji.next();
        if (!TextUtils.isEmpty(str)) {
          this.cf.put(str, Boolean.valueOf(true));
        }
      }
    }
  }
  
  public void a(qjg paramqjg)
  {
    super.a(paramqjg);
    this.nb.add(new WeakReference(paramqjg));
  }
  
  @SuppressLint({"SetTextI18n"})
  public void a(qjg paramqjg, int paramInt1, int paramInt2, qjq paramqjq)
  {
    super.a(paramqjg, paramInt1, paramInt2, paramqjq);
    paramqjq = paramqjq.vid;
    if (TextUtils.isEmpty(paramqjq)) {
      return;
    }
    ImageView localImageView = (ImageView)paramqjg.mItemView.findViewById(2131368925);
    localImageView.setVisibility(0);
    if ((this.cf.containsKey(paramqjq)) && (((Boolean)this.cf.get(paramqjq)).booleanValue()))
    {
      localImageView.setImageResource(2130845638);
      paramqjq = (TextView)paramqjg.mItemView.findViewById(2131379571);
      paramqjq.setVisibility(0);
      if (!this.cf.isEmpty()) {
        break label155;
      }
      paramqjg = acfp.m(2131714249);
      label118:
      paramqjq.setText(paramqjg);
      if (this.cf.isEmpty()) {
        break label192;
      }
    }
    label155:
    label192:
    for (boolean bool = true;; bool = false)
    {
      paramqjq.setEnabled(bool);
      return;
      localImageView.setImageResource(2130846607);
      break;
      paramqjg = acfp.m(2131714252) + this.cf.size() + ")";
      break label118;
    }
  }
  
  public void a(qjg paramqjg, View paramView)
  {
    super.a(paramqjg, paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368925: 
      paramqjg = paramqjg.a.vid;
      rom.checkNotNull(paramqjg);
      label87:
      TextView localTextView;
      if (this.cf.containsKey(paramqjg))
      {
        this.cf.remove(paramqjg);
        ((ImageView)paramView).setImageResource(2130846607);
        paramView = this.nb.iterator();
        do
        {
          if (!paramView.hasNext()) {
            break;
          }
          paramqjg = (qjg)((WeakReference)paramView.next()).get();
        } while (paramqjg == null);
        localTextView = (TextView)paramqjg.mItemView.findViewById(2131379571);
        if (!this.cf.isEmpty()) {
          break label282;
        }
        paramqjg = acfp.m(2131714251);
        label146:
        localTextView.setText(paramqjg);
        if (this.cf.isEmpty()) {
          break label320;
        }
      }
      label282:
      label320:
      for (boolean bool = true;; bool = false)
      {
        localTextView.setEnabled(bool);
        break label87;
        if (this.cf.size() >= this.MAX_COUNT)
        {
          paramqjg = aqha.a(this.a.n(), 230);
          paramqjg.setMessage(String.format(acfp.m(2131714254), new Object[] { Integer.valueOf(this.MAX_COUNT), plr.asY }));
          paramqjg.setPositiveButton(acfp.m(2131714248), new qjf(this));
          paramqjg.show();
          return;
        }
        this.cf.put(paramqjg, Boolean.valueOf(true));
        ((ImageView)paramView).setImageResource(2130845638);
        break;
        paramqjg = acfp.m(2131714247) + this.cf.size() + ")";
        break label146;
      }
    }
    boB();
  }
  
  public void a(qjg paramqjg, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramqjg.mItemView.findViewById(2131379571);
    if (this.cf.isEmpty())
    {
      paramqjg = acfp.m(2131714250);
      localTextView.setText(paramqjg);
      if (this.cf.isEmpty()) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = true;; paramBoolean = false)
    {
      localTextView.setEnabled(paramBoolean);
      return;
      paramqjg = acfp.m(2131714253) + this.cf.size() + ")";
      break;
    }
  }
  
  public void boB()
  {
    qje.a locala = new qje.a();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.cf.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(str);
      }
    }
    locala.isConfirmed = true;
    locala.mZ = localArrayList;
    ram.d("SelectVideoPlayerStrategy", "onPagerItemClick onClick complete: " + locala.mZ.toString());
    pmi.a().dispatch(locala);
    this.a.n().finish();
  }
  
  public static class a
    extends plt
  {
    public boolean isConfirmed = true;
    public ArrayList<String> mZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qje
 * JD-Core Version:    0.7.0.1
 */