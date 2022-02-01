import android.view.ViewGroup;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.concurrent.Executor;

public class mls
  implements ISuperPlayer.OnSeekCompleteListener, mlt
{
  private mlu.a jdField_a_of_type_Mlu$a;
  private mlu jdField_a_of_type_Mlu;
  private mlw b = new mlx();
  private Executor executor = acmo.a(64);
  private int height;
  private String path;
  private int position = -1;
  private int width;
  
  private void aPY()
  {
    aPZ();
    mlu localmlu = new mlu(2, this.path, this.position, this.width, this.height, this.jdField_a_of_type_Mlu$a);
    this.jdField_a_of_type_Mlu = localmlu;
    localmlu.a(this.b);
    localmlu.executeOnExecutor(this.executor, null);
  }
  
  private void aPZ()
  {
    if (this.jdField_a_of_type_Mlu != null) {
      this.jdField_a_of_type_Mlu.cancel(true);
    }
    this.jdField_a_of_type_Mlu = null;
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void a(String paramString, ViewGroup paramViewGroup, mlt parammlt)
  {
    this.path = paramString;
    this.b.a(paramString, paramViewGroup);
    this.b.a(parammlt);
    this.b.a(this);
  }
  
  public void a(mlu.a parama)
  {
    this.jdField_a_of_type_Mlu$a = parama;
  }
  
  public void onPause()
  {
    if (this.b != null) {
      this.b.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.b != null) {
      this.b.onResume();
    }
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    aPY();
  }
  
  public void rY(int paramInt)
  {
    if (this.position == paramInt) {
      return;
    }
    this.position = paramInt;
    this.b.a(paramInt, this);
  }
  
  public void stop()
  {
    this.jdField_a_of_type_Mlu$a = null;
    aPZ();
    this.b.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mls
 * JD-Core Version:    0.7.0.1
 */