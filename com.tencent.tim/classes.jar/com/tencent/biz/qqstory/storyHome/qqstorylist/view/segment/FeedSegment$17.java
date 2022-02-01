package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.a;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.VideoListLayout;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import pmi;
import qyd;
import qyk;
import ram;

public class FeedSegment$17
  implements Runnable
{
  public FeedSegment$17(qyk paramqyk, List paramList, VideoListLayout paramVideoListLayout, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    if (this.ou.size() == 1)
    {
      localObject1 = this.a.a();
      ram.b("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.val$vid);
      pmi.a().dispatch(new StoryPlayerActivity.a(new AnimationParam((View)localObject1), this.val$vid));
    }
    for (;;)
    {
      return;
      if (this.ou.size() == 2)
      {
        localObject1 = this.a.a();
        int i = 0;
        while (i < ((StoryHomeHorizontalListView)localObject1).getChildCount())
        {
          View localView = ((StoryHomeHorizontalListView)localObject1).getChildAt(i);
          Object localObject2 = localView.getTag();
          if ((localObject2 instanceof qyd))
          {
            localObject2 = (qyd)localObject2;
            if (((qyd)localObject2).position < this.ou.size())
            {
              localObject2 = (StoryVideoItem)this.ou.get(((qyd)localObject2).position);
              if (TextUtils.equals(this.val$vid, ((StoryVideoItem)localObject2).mVid))
              {
                ram.b("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.val$vid);
                pmi.a().dispatch(new StoryPlayerActivity.a(new AnimationParam(localView), this.val$vid));
                return;
              }
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.17
 * JD-Core Version:    0.7.0.1
 */