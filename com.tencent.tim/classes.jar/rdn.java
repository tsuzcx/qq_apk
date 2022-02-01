import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.tribe.async.reactive.SimpleObserver;

class rdn
  extends SimpleObserver<Bitmap>
{
  rdn(rdm paramrdm) {}
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.w("Q.qqstory.record.EditVideoPlayer", "blur the current frame error : " + paramError);
  }
  
  public void r(Bitmap paramBitmap)
  {
    super.onNext(paramBitmap);
    if (paramBitmap != null)
    {
      if (this.this$0.aHi)
      {
        this.this$0.nj.setImageBitmap(paramBitmap);
        ram.d("Q.qqstory.record.EditVideoPlayer", "blur current frame success");
      }
    }
    else {
      return;
    }
    ram.w("Q.qqstory.record.EditVideoPlayer", "finish blur current frame but play-cover-view is not visible");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdn
 * JD-Core Version:    0.7.0.1
 */