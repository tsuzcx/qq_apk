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

public class xeo
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private List<xer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xim jdField_a_of_type_Xim;
  private boolean jdField_a_of_type_Boolean;
  
  public xeo(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder, WEISHI.stMetaFeed paramstMetaFeed, int paramInt)
  {
    paramViewHolder = (xeq)paramViewHolder;
    paramstMetaFeed = paramstMetaFeed.material_thumburl.get();
    a(paramViewHolder.a, paramstMetaFeed);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = vzi.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      vzl.a(paramImageView, paramString, 68, 90, 4, vzl.b, "QQStoryMemory");
    }
  }
  
  public void a(List<WEISHI.stMetaFeed> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i;
    xer localxer;
    int j;
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 3;
      if (paramBoolean)
      {
        i = 2;
        localxer = new xer(null, 100);
        this.jdField_a_of_type_JavaUtilList.add(localxer);
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
        localxer = new xer((WEISHI.stMetaFeed)paramList.get(j), 101);
        this.jdField_a_of_type_JavaUtilList.add(localxer);
        j += 1;
      }
      notifyDataSetChanged();
      return;
    }
  }
  
  public void a(xim paramxim)
  {
    this.jdField_a_of_type_Xim = paramxim;
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
    return ((xer)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramInt = paramViewHolder.getAdapterPosition();
    xer localxer = (xer)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = localxer.jdField_a_of_type_Int;
    WEISHI.stMetaFeed localstMetaFeed = localxer.jdField_a_of_type_WEISHI_USER_GROWTHWEISHI$stMetaFeed;
    switch (i)
    {
    }
    for (;;)
    {
      paramViewHolder.itemView.setOnClickListener(new xep(this, localxer));
      return;
      if (i == 101)
      {
        a(paramViewHolder, localstMetaFeed, paramInt);
        continue;
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
          ((xeq)paramViewHolder).a.setImageResource(2130849193);
        } else {
          ((xeq)paramViewHolder).a.setImageResource(2130845043);
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
    return new xeq(localLayoutInflater.inflate(2131561027, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xeo
 * JD-Core Version:    0.7.0.1
 */