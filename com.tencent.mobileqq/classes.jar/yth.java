import WEISHI_USER_GROWTH.WEISHI.stMetaFeed;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class yth
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private List<ytk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yxf jdField_a_of_type_Yxf;
  private boolean jdField_a_of_type_Boolean;
  
  public yth(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, WEISHI.stMetaFeed paramstMetaFeed, int paramInt)
  {
    paramViewHolder = (ytj)paramViewHolder;
    paramstMetaFeed = paramstMetaFeed.material_thumburl.get();
    a(paramViewHolder.a, paramstMetaFeed);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = xoa.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      xod.a(paramImageView, paramString, 68, 90, 4, xod.b, "QQStoryMemory");
    }
  }
  
  public void a(List<WEISHI.stMetaFeed> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    ytk localytk;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 3;
      if (paramBoolean)
      {
        i = 2;
        localytk = new ytk(null, 100);
        this.jdField_a_of_type_JavaUtilList.add(localytk);
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
        localytk = new ytk((WEISHI.stMetaFeed)paramList.get(j), 101);
        this.jdField_a_of_type_JavaUtilList.add(localytk);
        j += 1;
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(yxf paramyxf)
  {
    this.jdField_a_of_type_Yxf = paramyxf;
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if (this.jdField_a_of_type_JavaUtilList.size() > 3) {
        return 3;
      }
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int getItemViewType(int paramInt)
  {
    return ((ytk)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramInt = paramViewHolder.getAdapterPosition();
    ytk localytk = (ytk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localytk.jdField_a_of_type_Int;
    WEISHI.stMetaFeed localstMetaFeed = localytk.jdField_a_of_type_WEISHI_USER_GROWTHWEISHI$stMetaFeed;
    switch (i)
    {
    }
    for (;;)
    {
      paramViewHolder.itemView.setOnClickListener(new yti(this, localytk));
      return;
      if (i == 101)
      {
        a(paramViewHolder, localstMetaFeed, paramInt);
        continue;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          ((ytj)paramViewHolder).a.setImageResource(2130849624);
        } else {
          ((ytj)paramViewHolder).a.setImageResource(2130845408);
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
    return new ytj(localLayoutInflater.inflate(2131561213, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yth
 * JD-Core Version:    0.7.0.1
 */