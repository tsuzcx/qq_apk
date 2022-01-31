import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.SparseBooleanArray;
import android.view.View;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class wtz
  extends AnimatorListenerAdapter
{
  public wtz(VideoPlayerView paramVideoPlayerView, WeakReference paramWeakReference, int paramInt1, boolean paramBoolean, int paramInt2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean) {
      VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView, this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, this.b, false);
    }
    while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_Int != 0) || (VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView) == null) || (VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView).get(((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getId()))) {
      return;
    }
    ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setVisibility(8);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_Int == 1) && (VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView) != null) && (!VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView).get(((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getId()))) {
      ((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).setVisibility(0);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (this.jdField_a_of_type_Int == 0) && (VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView) != null) && (!VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView).get(((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getId()))) {
      VideoPlayerView.a(this.jdField_a_of_type_ComTencentBizSubscribeVideoplayerVideoPlayerView).put(this.jdField_a_of_type_JavaLangRefWeakReference, Integer.valueOf(((View)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getVisibility()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtz
 * JD-Core Version:    0.7.0.1
 */