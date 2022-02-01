import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;

public class aynm
  extends aynh<aync>
{
  private ImageView IS;
  private ImageView IT;
  
  public aynm(Context paramContext, FaceListPage paramFaceListPage)
  {
    super(paramContext, paramFaceListPage);
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    View localView;
    if (this.context != null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131561834, null);
      this.IS = ((ImageView)localView.findViewById(2131382083));
      this.IT = ((ImageView)localView.findViewById(2131376626));
      if ((this.context instanceof EditVideoActivity))
      {
        localObject = ((EditVideoActivity)this.context).a();
        if (localObject != null)
        {
          localObject = ((aygz)localObject).a;
          if (localObject != null)
          {
            this.IS.setOnClickListener((View.OnClickListener)localObject);
            this.IT.setOnClickListener((View.OnClickListener)localObject);
            int i = rpq.bsk * 54 / 750;
            ((LinearLayout.LayoutParams)this.IS.getLayoutParams()).setMargins(i, 0, i, 0);
            ((LinearLayout.LayoutParams)this.IT.getLayoutParams()).setMargins(i, 0, i, 0);
          }
        }
        localView.setLayoutParams(new AbsListView.LayoutParams(paramViewGroup.getWidth(), paramViewGroup.getHeight()));
      }
    }
    for (localObject = localView;; localObject = null)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      if (!(this.context instanceof EditPicActivity)) {
        break;
      }
      localObject = ((EditPicActivity)this.context).a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aynm
 * JD-Core Version:    0.7.0.1
 */