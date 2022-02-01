package org.junit.internal.requests;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Sorter;

public class SortingRequest
  extends Request
{
  private final Comparator<Description> comparator;
  private final Request request;
  
  public SortingRequest(Request paramRequest, Comparator<Description> paramComparator)
  {
    this.request = paramRequest;
    this.comparator = paramComparator;
  }
  
  public Runner getRunner()
  {
    Runner localRunner = this.request.getRunner();
    new Sorter(this.comparator).apply(localRunner);
    return localRunner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.requests.SortingRequest
 * JD-Core Version:    0.7.0.1
 */