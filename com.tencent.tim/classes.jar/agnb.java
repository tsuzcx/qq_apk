import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class agnb
  extends BaseAdapter
{
  private List<agnc> AO;
  private BaseFileAssistantActivity a;
  private View.OnClickListener bJ;
  private LayoutInflater mInflater;
  
  public agnb(BaseFileAssistantActivity paramBaseFileAssistantActivity, List<agnc> paramList, View.OnClickListener paramOnClickListener)
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
    if (((agnc)this.AO.get(paramInt)).type == 0) {
      return 0;
    }
    if (((agnc)this.AO.get(paramInt)).type == 3) {
      return 3;
    }
    if (((agnc)this.AO.get(paramInt)).type == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (agnc)this.AO.get(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    if (paramView == null)
    {
      localObject1 = new agnb.a();
      paramView = this.mInflater.inflate(((agnc)localObject2).cYb, paramViewGroup, false);
      paramView = new RedTouch(this.a, paramView).c(30).a();
      paramView.setTag(localObject1);
      if ((((agnc)localObject2).type == 0) || (((agnc)localObject2).type == 3))
      {
        ((agnb.a)localObject1).CO = paramView.findViewById(2131364341);
        ((agnb.a)localObject1).CO.setOnClickListener(this.bJ);
        ((agnb.a)localObject1).zJ = ((ImageView)paramView.findViewById(2131364340));
        ((agnb.a)localObject1).zK = ((ImageView)paramView.findViewById(2131377000));
        ((agnb.a)localObject1).Su = ((TextView)paramView.findViewById(2131364342));
        ((agnb.a)localObject1).OK = ((TextView)paramView.findViewById(2131372578));
        ((agnb.a)localObject1).Jc = ((TextView)paramView.findViewById(2131378708));
      }
    }
    label206:
    label864:
    for (;;)
    {
      ((agnb.a)localObject1).category = ((agnc)localObject2).category;
      ((agnb.a)localObject1).categoryId = ((agnc)localObject2).categoryId;
      if (((agnc)localObject2).type == 0) {
        if (((agnc)localObject2).cev)
        {
          ((agnb.a)localObject1).zK.setVisibility(0);
          label251:
          if (!((agnc)localObject2).ceu) {
            break label516;
          }
          ((agnb.a)localObject1).zJ.setVisibility(0);
          ((agnb.a)localObject1).zJ.setBackgroundResource(((agnc)localObject2).iconId);
          if (TextUtils.isEmpty(((agnc)localObject2).state)) {
            break label529;
          }
          ((agnb.a)localObject1).Jc.setText(((agnc)localObject2).state);
          ((agnb.a)localObject1).Jc.setVisibility(0);
          ((agnb.a)localObject1).Su.setText(((agnc)localObject2).name);
          ((agnb.a)localObject1).CO.setTag(localObject1);
          if (((agnc)localObject2).isShowNum) {
            ((agnb.a)localObject1).OK.setText("(" + ((agnc)localObject2).num + ")");
          }
          switch (((agnc)localObject2).cPu)
          {
          default: 
            ((agnb.a)localObject1).CO.setBackgroundResource(2130839682);
            if (16 != ((agnc)localObject2).category) {
              break;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = paramView;
        break;
        if ((((agnc)localObject2).type != 1) && (((agnc)localObject2).type != 4)) {
          break label864;
        }
        ((agnb.a)localObject1).Sv = ((TextView)paramView.findViewById(2131365985));
        ((agnb.a)localObject1).desc = ((TextView)paramView.findViewById(2131379419));
        break label206;
        localObject1 = (agnb.a)paramView.getTag();
        break label206;
        ((agnb.a)localObject1).zK.setVisibility(8);
        break label251;
        ((agnb.a)localObject1).zJ.setVisibility(8);
        break label281;
        ((agnb.a)localObject1).Jc.setVisibility(8);
        break label314;
        ((agnb.a)localObject1).CO.setBackgroundResource(2130839682);
        break label426;
        ((agnb.a)localObject1).CO.setBackgroundResource(2130839701);
        break label426;
        ((agnb.a)localObject1).CO.setBackgroundResource(2130839689);
        break label426;
        ((agnb.a)localObject1).CO.setBackgroundResource(2130839695);
        break label426;
        if (17 != ((agnc)localObject2).category) {
          if (22 == ((agnc)localObject2).category)
          {
            localObject2 = ((altq)this.a.app.getManager(36)).getAppInfoByPath(String.valueOf("100160.100163"));
            ((RedTouch)paramView).e((BusinessInfoCheckUpdate.AppInfo)localObject2);
            if (((RedTouch)paramView).aux()) {
              ((agnb.a)localObject1).zK.setVisibility(4);
            } else {
              ((agnb.a)localObject1).zK.setVisibility(8);
            }
          }
          else
          {
            ((RedTouch)paramView).dGB();
            continue;
            if (((agnc)localObject2).type == 1)
            {
              if (((agnc)localObject2).isShowNum) {
                ((agnb.a)localObject1).desc.setText(((agnc)localObject2).name);
              } else {
                ((agnb.a)localObject1).desc.setVisibility(4);
              }
            }
            else if (((agnc)localObject2).type == 4) {
              if (((agnc)localObject2).isShowNum)
              {
                ((agnb.a)localObject1).desc.setGravity(17);
                if (!aqlr.hasShortCut(this.a, new String[] { this.a.getString(2131693537) }))
                {
                  localObject2 = ahav.a(((agnc)localObject2).name, ((agnc)localObject2).name, null);
                  ((agnb.a)localObject1).desc.setClickable(true);
                  ((agnb.a)localObject1).desc.setOnClickListener(this.bJ);
                  ((agnb.a)localObject1).desc.setText((CharSequence)localObject2);
                  ((agnb.a)localObject1).desc.setTag(localObject1);
                }
              }
              else
              {
                ((agnb.a)localObject1).desc.setVisibility(4);
              }
            }
          }
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
    public View CO;
    public TextView Jc;
    public TextView OK;
    public TextView Su;
    public TextView Sv;
    public int category;
    public String categoryId;
    public TextView desc;
    public ImageView zJ;
    public ImageView zK;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agnb
 * JD-Core Version:    0.7.0.1
 */