import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ausr
  extends BaseAdapter
{
  Context mContext;
  final List<ausr.b> mData;
  
  public ausr(Context paramContext)
  {
    this.mContext = paramContext;
    this.mData = new ArrayList();
  }
  
  public static ausj a(Context paramContext, ausr paramausr, AdapterView.OnItemClickListener paramOnItemClickListener, DialogInterface.OnDismissListener paramOnDismissListener, ausj.a parama, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (paramausr == null) {
        return null;
      }
      ausj localausj = (ausj)auss.a(paramContext, null);
      paramContext = (GridView)View.inflate(paramContext, 2131563287, null);
      paramContext.setBackgroundResource(2130837673);
      paramContext.setAdapter(paramausr);
      paramContext.setOnItemClickListener(paramOnItemClickListener);
      localausj.addView(paramContext);
      localausj.addCancelButton(2131721058);
      if (paramBoolean) {
        localausj.setOnDismissListener(new ausr.a(paramOnDismissListener));
      }
      for (;;)
      {
        localausj.a(parama);
        return localausj;
        localausj.setOnDismissListener(paramOnDismissListener);
      }
    }
    return null;
  }
  
  public static ausr.b a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt <= 7) {
        localObject1 = new ausr.b();
      }
    }
    switch (paramInt)
    {
    default: 
      return localObject1;
    case 3: 
      ((ausr.b)localObject1).esp = 3;
      ((ausr.b)localObject1).textId = 2131720180;
      ((ausr.b)localObject1).iconId = 2130839249;
      ((ausr.b)localObject1).esq = 2131720773;
      return localObject1;
    case 2: 
      ((ausr.b)localObject1).esp = 2;
      ((ausr.b)localObject1).textId = 2131720191;
      ((ausr.b)localObject1).iconId = 2130839256;
      ((ausr.b)localObject1).esq = 2131720790;
      return localObject1;
    case 0: 
      ((ausr.b)localObject1).esp = 0;
      ((ausr.b)localObject1).textId = 2131694034;
      ((ausr.b)localObject1).iconId = 2130839252;
      ((ausr.b)localObject1).esq = 2131720782;
      return localObject1;
    case 1: 
      ((ausr.b)localObject1).esp = 1;
      ((ausr.b)localObject1).textId = 2131720185;
      ((ausr.b)localObject1).iconId = 2130839253;
      ((ausr.b)localObject1).esq = 2131720783;
      return localObject1;
    case 5: 
      ((ausr.b)localObject1).esp = 5;
      ((ausr.b)localObject1).textId = 2131717155;
      ((ausr.b)localObject1).iconId = 2130843301;
      ((ausr.b)localObject1).esq = 2131693309;
      return localObject1;
    case 4: 
      ((ausr.b)localObject1).esp = 4;
      ((ausr.b)localObject1).iconId = 2130839246;
      ((ausr.b)localObject1).textId = 2131720166;
      ((ausr.b)localObject1).esq = 2131720766;
      return localObject1;
    case 6: 
      ((ausr.b)localObject1).esp = 4;
      ((ausr.b)localObject1).iconId = 2130839246;
      ((ausr.b)localObject1).textId = 2131720164;
      ((ausr.b)localObject1).esq = 2131720772;
      return localObject1;
    }
    ((ausr.b)localObject1).esp = 7;
    ((ausr.b)localObject1).iconId = 2130839247;
    ((ausr.b)localObject1).textId = 2131720151;
    ((ausr.b)localObject1).esq = 2131720769;
    return localObject1;
  }
  
  public int getCount()
  {
    return this.mData.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mData.size())) {
      return this.mData.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    ausr.b localb = (ausr.b)getItem(paramInt);
    if (localb != null) {
      return localb.esp;
    }
    return -1L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ausr.b localb = (ausr.b)getItem(paramInt);
    if (paramView == null) {
      paramView = LayoutInflater.from(this.mContext).inflate(2131563252, null);
    }
    for (;;)
    {
      ImageView localImageView = (ImageView)paramView.findViewById(2131362847);
      TextView localTextView = (TextView)paramView.findViewById(2131362859);
      if (localb != null)
      {
        localImageView.setImageResource(localb.iconId);
        localTextView.setText(localb.textId);
        if (AppSetting.enableTalkBack)
        {
          if (localb == null) {
            break label135;
          }
          paramView.setContentDescription(this.mContext.getString(localb.esq));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localImageView.setImageResource(2130849080);
        localTextView.setText("");
        break;
        label135:
        paramView.setContentDescription("");
      }
    }
  }
  
  public void setData(List<ausr.b> paramList)
  {
    this.mData.clear();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ausr.b localb = (ausr.b)paramList.next();
        if ((localb != null) && (localb.esp >= 0)) {
          this.mData.add(localb);
        }
      }
    }
    notifyDataSetChanged();
  }
  
  static class a
    implements DialogInterface.OnDismissListener
  {
    private WeakReference<DialogInterface.OnDismissListener> iI;
    
    public a(DialogInterface.OnDismissListener paramOnDismissListener)
    {
      this.iI = new WeakReference(paramOnDismissListener);
    }
    
    public void onDismiss(DialogInterface paramDialogInterface)
    {
      DialogInterface.OnDismissListener localOnDismissListener = (DialogInterface.OnDismissListener)this.iI.get();
      if (localOnDismissListener != null) {
        localOnDismissListener.onDismiss(paramDialogInterface);
      }
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.i("Q.dating", 2, "CustomDismissListener, lis is null");
    }
  }
  
  public static class b
  {
    public int esp;
    public int esq;
    public int iconId;
    public int textId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausr
 * JD-Core Version:    0.7.0.1
 */