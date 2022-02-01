package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.StoryPlayerActivity.a;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationParam;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import pmi;
import qyd;
import qyk;
import ram;

public class FeedSegment$18
  implements Runnable
{
  public FeedSegment$18(qyk paramqyk, StoryHomeHorizontalListView paramStoryHomeHorizontalListView, List paramList, String paramString) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.e.getChildCount())
      {
        View localView = this.e.getChildAt(i);
        Object localObject = localView.getTag();
        if ((localObject instanceof qyd))
        {
          localObject = (qyd)localObject;
          if (((qyd)localObject).position < this.ou.size())
          {
            localObject = (StoryVideoItem)this.ou.get(((qyd)localObject).position);
            if (TextUtils.equals(this.val$vid, ((StoryVideoItem)localObject).mVid))
            {
              ram.b("Q.qqstory.home:FeedSegment", "broadcast close animation %s", this.val$vid);
              pmi.a().dispatch(new StoryPlayerActivity.a(new AnimationParam(localView), this.val$vid));
            }
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.18
 * JD-Core Version:    0.7.0.1
 */