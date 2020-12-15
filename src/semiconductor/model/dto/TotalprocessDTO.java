package semiconductor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor

public class TotalprocessDTO {
	private int waferId;
	private String clean1;
	private String clean2;
	private String rinse1;
	private String clean3;
	private String rinse2;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalprocessDTO [waferId=");
		builder.append(waferId);
		builder.append(", clean1=");
		builder.append(clean1);
		builder.append(", clean2=");
		builder.append(clean2);
		builder.append(", rinse1=");
		builder.append(rinse1);
		builder.append(", clean3=");
		builder.append(clean3);
		builder.append(", rinse2=");
		builder.append(rinse2);
		builder.append("]");
		return builder.toString();
	}
}
