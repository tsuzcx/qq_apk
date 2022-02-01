import android.util.SparseArray;
import com.tencent.biz.qqstory.widget.RotateCircleImageView.BorderStyle;

public final class rtg
  extends SparseArray<RotateCircleImageView.BorderStyle>
{
  public rtg(int paramInt)
  {
    super(paramInt);
    append(0, RotateCircleImageView.BorderStyle.STILL);
    append(1, RotateCircleImageView.BorderStyle.ROTATE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rtg
 * JD-Core Version:    0.7.0.1
 */