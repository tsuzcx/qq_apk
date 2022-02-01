import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;

public class mvp
  extends OrientationEventListener
{
  public mvp(VideoFeedsListView paramVideoFeedsListView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (VideoFeedsListView.a(this.this$0)) {}
    label10:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label10;
                break label10;
                break label10;
                break label10;
                do
                {
                  return;
                } while ((!VideoFeedsListView.b(this.this$0)) || (!VideoFeedsListView.c(this.this$0)) || (VideoFeedsListView.a(this.this$0) == 1) || (VideoFeedsListView.d(this.this$0)) || (!VideoFeedsListView.a(this.this$0, paramInt)) || ((!VideoFeedsListView.e(this.this$0)) && (VideoFeedsListView.f(this.this$0))));
                if ((paramInt < 0) || ((paramInt > 30) && (paramInt < 330))) {
                  break;
                }
              } while ((VideoFeedsListView.b(this.this$0) != -1) && (VideoFeedsListView.b(this.this$0) != 0));
              VideoFeedsListView.a(this.this$0, -1);
            } while (VideoFeedsListView.c(this.this$0) == 0);
            this.this$0.ou(true);
            return;
            if ((paramInt < 70) || (paramInt > 110)) {
              break;
            }
          } while ((VideoFeedsListView.b(this.this$0) != -1) && (VideoFeedsListView.b(this.this$0) != 2));
          VideoFeedsListView.a(this.this$0, -1);
        } while (VideoFeedsListView.c(this.this$0) == 2);
        VideoFeedsListView.a(this.this$0, 2, true);
        return;
      } while ((paramInt < 250) || (paramInt > 290) || ((VideoFeedsListView.b(this.this$0) != -1) && (VideoFeedsListView.b(this.this$0) != 1)));
      VideoFeedsListView.a(this.this$0, -1);
    } while (VideoFeedsListView.c(this.this$0) == 1);
    VideoFeedsListView.a(this.this$0, 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvp
 * JD-Core Version:    0.7.0.1
 */