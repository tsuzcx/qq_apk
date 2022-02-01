import WEISHI_USER_GROWTH.WEISHI.stMetaFeed;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class soy
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private srn.a jdField_a_of_type_Srn$a;
  private boolean aMs;
  private List<soy.b> py = new ArrayList();
  
  public soy(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, WEISHI.stMetaFeed paramstMetaFeed, int paramInt)
  {
    paramViewHolder = (soy.a)paramViewHolder;
    paramstMetaFeed = paramstMetaFeed.material_thumburl.get();
    d(paramViewHolder.oC, paramstMetaFeed);
  }
  
  private void d(ImageView paramImageView, String paramString)
  {
    paramString = rpn.gm(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      rpq.a(paramImageView, paramString, 68, 90, 4, rpq.dl, "QQStoryMemory");
    }
  }
  
  public void a(srn.a parama)
  {
    this.jdField_a_of_type_Srn$a = parama;
  }
  
  public int getItemCount()
  {
    if ((this.py != null) && (this.py.size() > 0))
    {
      if (this.py.size() > 3) {
        return 3;
      }
      return this.py.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((soy.b)this.py.get(paramInt)).dataType;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = paramViewHolder.getAdapterPosition();
    soy.b localb = (soy.b)this.py.get(i);
    int j = localb.dataType;
    WEISHI.stMetaFeed localstMetaFeed = localb.a;
    switch (j)
    {
    }
    for (;;)
    {
      paramViewHolder.itemView.setOnClickListener(new soz(this, localb));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
      if (j == 101)
      {
        a(paramViewHolder, localstMetaFeed, i);
        continue;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          ((soy.a)paramViewHolder).oC.setImageResource(2130851296);
        } else {
          ((soy.a)paramViewHolder).oC.setImageResource(2130846794);
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      return null;
    }
    return new soy.a(localLayoutInflater.inflate(2131561623, paramViewGroup, false));
  }
  
  public void setData(List<WEISHI.stMetaFeed> paramList, boolean paramBoolean)
  {
    this.py.clear();
    this.aMs = paramBoolean;
    int i;
    soy.b localb;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 3;
      if (paramBoolean)
      {
        i = 2;
        localb = new soy.b(null, 100);
        this.py.add(localb);
      }
      j = paramList.size();
      if (j >= i) {
        break label133;
      }
      i = j;
    }
    label133:
    for (;;)
    {
      j = 0;
      while (j < i)
      {
        localb = new soy.b((WEISHI.stMetaFeed)paramList.get(j), 101);
        this.py.add(localb);
        j += 1;
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  static class a
    extends RecyclerView.ViewHolder
  {
    final StoryCoverView c;
    final ImageView oC;
    
    a(View paramView)
    {
      super();
      this.oC = ((ImageView)paramView.findViewById(2131368722));
      this.c = ((StoryCoverView)paramView.findViewById(2131365502));
    }
  }
  
  public static class b
  {
    WEISHI.stMetaFeed a = null;
    int dataType;
    
    b(WEISHI.stMetaFeed paramstMetaFeed, int paramInt)
    {
      this.a = paramstMetaFeed;
      this.dataType = paramInt;
    }
    
    public int getDataType()
    {
      return this.dataType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     soy
 * JD-Core Version:    0.7.0.1
 */