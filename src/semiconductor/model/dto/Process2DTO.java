package semiconductor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Process2DTO {
	private int waferId;
	private int clean3;
	private int rinse2;

	public Process2DTO() {
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Process2DTO [waferId=");
		builder.append(waferId);
		builder.append(", clean3=");
		builder.append(clean3);
		builder.append(", rinse2=");
		builder.append(rinse2);
		builder.append("]");
		return builder.toString();
	}

}
