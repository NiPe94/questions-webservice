package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Question
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-16T09:21:50.059Z[GMT]")
public class Question   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("tags")
  @Valid
  private List<String> tags = null;

  @JsonProperty("is_answered")
  private Boolean isAnswered = false;

  @JsonProperty("view_count")
  private Long viewCount = null;

  @JsonProperty("answer_count")
  private Long answerCount = null;

  @JsonProperty("creation_date")
  private OffsetDateTime creationDate = null;

  @JsonProperty("user_id")
  private Long userId = null;

  public Question id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Question tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public Question addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<String>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(value = "")
  
    public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  public Question isAnswered(Boolean isAnswered) {
    this.isAnswered = isAnswered;
    return this;
  }

  /**
   * Get isAnswered
   * @return isAnswered
  **/
  @ApiModelProperty(value = "")
  
    public Boolean isIsAnswered() {
    return isAnswered;
  }

  public void setIsAnswered(Boolean isAnswered) {
    this.isAnswered = isAnswered;
  }

  public Question viewCount(Long viewCount) {
    this.viewCount = viewCount;
    return this;
  }

  /**
   * Get viewCount
   * @return viewCount
  **/
  @ApiModelProperty(value = "")
  
    public Long getViewCount() {
    return viewCount;
  }

  public void setViewCount(Long viewCount) {
    this.viewCount = viewCount;
  }

  public Question answerCount(Long answerCount) {
    this.answerCount = answerCount;
    return this;
  }

  /**
   * Get answerCount
   * @return answerCount
  **/
  @ApiModelProperty(value = "")
  
    public Long getAnswerCount() {
    return answerCount;
  }

  public void setAnswerCount(Long answerCount) {
    this.answerCount = answerCount;
  }

  public Question creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Get creationDate
   * @return creationDate
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public Question userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")
  
    public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return Objects.equals(this.id, question.id) &&
        Objects.equals(this.tags, question.tags) &&
        Objects.equals(this.isAnswered, question.isAnswered) &&
        Objects.equals(this.viewCount, question.viewCount) &&
        Objects.equals(this.answerCount, question.answerCount) &&
        Objects.equals(this.creationDate, question.creationDate) &&
        Objects.equals(this.userId, question.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tags, isAnswered, viewCount, answerCount, creationDate, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Question {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    isAnswered: ").append(toIndentedString(isAnswered)).append("\n");
    sb.append("    viewCount: ").append(toIndentedString(viewCount)).append("\n");
    sb.append("    answerCount: ").append(toIndentedString(answerCount)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
