package com.tencent.qqmail.tile;

import android.os.Bundle;
import android.service.quicksettings.TileService;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs;
import com.tencent.qqmail.utilities.schedule.QMScheduledJobs.FromType;
import moai.oss.KvHelper;

public class BaseTileService
  extends TileService
{
  private void checkScheduledJobs()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("from", QMScheduledJobs.FromType.TILE_SERVICE);
    QMScheduledJobs.doJobs(localBundle);
  }
  
  public void onClick()
  {
    super.onClick();
    KvHelper.eventTileServiceOnclick(new double[0]);
    checkScheduledJobs();
  }
  
  public void onStartListening()
  {
    super.onStartListening();
    KvHelper.eventTileServiceOnstartlisten(new double[0]);
    checkScheduledJobs();
  }
  
  public void onStopListening()
  {
    super.onStopListening();
    KvHelper.eventTileServiceOnstoplisten(new double[0]);
    checkScheduledJobs();
  }
  
  public void onTileAdded()
  {
    super.onTileAdded();
    KvHelper.eventTileServiceOnadd(new double[0]);
    checkScheduledJobs();
  }
  
  public void onTileRemoved()
  {
    super.onTileRemoved();
    KvHelper.eventTileServiceOnremove(new double[0]);
    checkScheduledJobs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.tile.BaseTileService
 * JD-Core Version:    0.7.0.1
 */