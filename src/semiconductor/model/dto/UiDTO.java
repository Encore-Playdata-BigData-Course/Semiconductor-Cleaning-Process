package semiconductor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor

public class UiDTO {
	private int waferId;
	private String result;
	private String errpoint;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UiDTO [waferId=");
		builder.append(waferId);
		builder.append(", result=");
		builder.append(result);
		builder.append(", errpoint=");
		builder.append(errpoint);
		builder.append("]");
		return builder.toString();
	}

}
