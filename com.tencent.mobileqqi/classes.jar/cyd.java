import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.widget.XListView;

class cyd
  implements Runnable
{
  cyd(cyc paramcyc, String paramString, Bitmap paramBitmap, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Cyc.a.a == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_Cyc.a.a.getChildCount();
        int i = 0;
        if (i < j)
        {
          localObject = this.jdField_a_of_type_Cyc.a.a.getChildAt(i);
          LebaListViewAdapter.CornerListItemHolder localCornerListItemHolder = (LebaListViewAdapter.CornerListItemHolder)((View)localObject).getTag();
          if ((localCornerListItemHolder == null) || (localCornerListItemHolder.a == null) || (localCornerListItemHolder.a.a == null) || (!this.jdField_a_of_type_JavaLangString.equals(localCornerListItemHolder.a.a.strPkgName))) {}
          for (;;)
          {
            i += 1;
            break;
            localObject = (ImageView)((View)localObject).findViewById(2131231555);
            if (localObject != null) {
              ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
            }
          }
        }
      } while (this.jdField_a_of_type_Boolean);
      localObject = this.jdField_a_of_type_Cyc.a.a.findViewWithTag(this.jdField_a_of_type_JavaLangString);
    } while ((localObject == null) || (!(localObject instanceof ImageView)));
    ((ImageView)localObject).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cyd
 * JD-Core Version:    0.7.0.1
 */