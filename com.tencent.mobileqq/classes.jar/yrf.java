import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import java.util.ArrayList;

public class yrf
  extends AsyncTask<ArrayList<Bitmap>, Integer, ArrayList<String>>
  implements bmil
{
  private int jdField_a_of_type_Int;
  
  public yrf(EditGifImage paramEditGifImage) {}
  
  protected ArrayList<String> a(ArrayList<Bitmap>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (isCancelled())) {
      return null;
    }
    ArrayList<Bitmap> localArrayList1 = paramVarArgs[0];
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Int = localArrayList1.size();
    bmik.a().a(this);
    paramVarArgs = localArrayList;
    if (!isCancelled()) {}
    try
    {
      paramVarArgs = bmik.a().a(localArrayList1);
      localArrayList1.clear();
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs.printStackTrace();
        paramVarArgs = localArrayList;
      }
    }
  }
  
  public void a(int paramInt)
  {
    publishProgress(new Integer[] { Integer.valueOf(paramInt) });
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1) || (isCancelled())) {}
    do
    {
      return;
      EditGifImage.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage, paramArrayList);
    } while (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.e);
    EditGifImage.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.a.a(true, true);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.e) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditGifImage.a.a.a(paramVarArgs[0].intValue(), this.jdField_a_of_type_Int);
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrf
 * JD-Core Version:    0.7.0.1
 */