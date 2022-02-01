import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import java.util.List;

public class atwc
  extends BaseAdapter
{
  private List<atwd> AO;
  private BaseFileAssistantActivity a;
  private View.OnClickListener bJ;
  private LayoutInflater mInflater;
  
  public atwc(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<atwd> paramList, View.OnClickListener paramOnClickListener)
  {
    this.a = paramBaseFileAssistantActivity;
    this.AO = paramList;
    this.mInflater = LayoutInflater.from(this.a);
    this.bJ = paramOnClickListener;
  }
  
  public int getCount()
  {
    return this.AO.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.AO.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((atwd)this.AO.get(paramInt)).type == 0) {
      return 0;
    }
    if (((atwd)this.AO.get(paramInt)).type == 3) {
      return 3;
    }
    if (((atwd)this.AO.get(paramInt)).type == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    atwd localatwd = (atwd)this.AO.get(paramInt);
    Object localObject2;
    Object localObject1;
    if (localatwd == null)
    {
      localObject2 = null;
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject2;
    }
    RedTouch localRedTouch;
    if (paramView == null)
    {
      localObject2 = new atwc.a();
      paramView = this.mInflater.inflate(localatwd.cYb, paramViewGroup, false);
      localRedTouch = new RedTouch(this.a, paramView).c(30).a();
      localRedTouch.setTag(localObject2);
      if ((localatwd.type == 0) || (localatwd.type == 3))
      {
        ((atwc.a)localObject2).nA = ((RelativeLayout)localRedTouch.findViewById(2131364341));
        ((atwc.a)localObject2).nA.setOnClickListener(this.bJ);
        ((atwc.a)localObject2).zJ = ((ImageView)localRedTouch.findViewById(2131364340));
        ((atwc.a)localObject2).zK = ((ImageView)localRedTouch.findViewById(2131377000));
        ((atwc.a)localObject2).Su = ((TextView)localRedTouch.findViewById(2131364342));
        ((atwc.a)localObject2).OK = ((TextView)localRedTouch.findViewById(2131372578));
        ((atwc.a)localObject2).Jc = ((TextView)localRedTouch.findViewById(2131378708));
        paramView = localRedTouch;
        localObject1 = localObject2;
        label228:
        ((atwc.a)localObject1).category = localatwd.category;
        ((atwc.a)localObject1).categoryId = localatwd.categoryId;
        if (localatwd.type != 0) {
          break label623;
        }
        if (!localatwd.cev) {
          break label532;
        }
        ((atwc.a)localObject1).zK.setVisibility(0);
        label273:
        if (!localatwd.ceu) {
          break label545;
        }
        ((atwc.a)localObject1).zJ.setVisibility(0);
        ((atwc.a)localObject1).zJ.setBackgroundResource(localatwd.iconId);
        label303:
        if (localatwd.state == null) {
          break label558;
        }
        ((atwc.a)localObject1).Jc.setVisibility(0);
        ((atwc.a)localObject1).Jc.setText(localatwd.state);
        label333:
        ((atwc.a)localObject1).Su.setText(localatwd.name);
        ((atwc.a)localObject1).nA.setTag(localObject1);
        if (localatwd.isShowNum) {
          ((atwc.a)localObject1).OK.setText("(" + localatwd.num + ")");
        }
        switch (localatwd.cPu)
        {
        default: 
          ((atwc.a)localObject1).nA.setBackgroundResource(2130839682);
        }
      }
    }
    for (;;)
    {
      localObject1 = paramView;
      localObject2 = paramView;
      break;
      if (localatwd.type != 1)
      {
        localObject1 = localObject2;
        paramView = localRedTouch;
        if (localatwd.type != 4) {
          break label228;
        }
      }
      ((atwc.a)localObject2).Sv = ((TextView)localRedTouch.findViewById(2131365985));
      ((atwc.a)localObject2).desc = ((TextView)localRedTouch.findViewById(2131379419));
      localObject1 = localObject2;
      paramView = localRedTouch;
      break label228;
      localObject1 = (atwc.a)paramView.getTag();
      break label228;
      label532:
      ((atwc.a)localObject1).zK.setVisibility(8);
      break label273;
      label545:
      ((atwc.a)localObject1).zJ.setVisibility(8);
      break label303;
      label558:
      ((atwc.a)localObject1).Jc.setVisibility(8);
      break label333;
      ((atwc.a)localObject1).nA.setBackgroundResource(2130839682);
      continue;
      ((atwc.a)localObject1).nA.setBackgroundResource(2130839701);
      continue;
      ((atwc.a)localObject1).nA.setBackgroundResource(2130839689);
      continue;
      ((atwc.a)localObject1).nA.setBackgroundResource(2130839695);
      continue;
      label623:
      if (localatwd.type == 1)
      {
        if (localatwd.isShowNum) {
          ((atwc.a)localObject1).desc.setText(localatwd.name);
        } else {
          ((atwc.a)localObject1).desc.setVisibility(4);
        }
      }
      else if (localatwd.type == 4) {
        if (localatwd.isShowNum)
        {
          ((LinearLayout.LayoutParams)((atwc.a)localObject1).desc.getLayoutParams()).height = ((int)paramView.getResources().getDimension(2131296927));
          if (!aqlr.hasShortCut(this.a, new String[] { this.a.getString(2131693537) }))
          {
            localObject2 = audx.a(localatwd.name, localatwd.name, null);
            ((atwc.a)localObject1).desc.setClickable(true);
            ((atwc.a)localObject1).desc.setOnClickListener(this.bJ);
            ((atwc.a)localObject1).desc.setText((CharSequence)localObject2);
            ((atwc.a)localObject1).desc.setTag(localObject1);
          }
        }
        else
        {
          ((atwc.a)localObject1).desc.setVisibility(4);
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public class a
    implements Cloneable
  {
    public TextView Jc;
    public TextView OK;
    public TextView Su;
    public TextView Sv;
    public int category;
    public String categoryId;
    public TextView desc;
    public RelativeLayout nA;
    public ImageView zJ;
    public ImageView zK;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwc
 * JD-Core Version:    0.7.0.1
 */