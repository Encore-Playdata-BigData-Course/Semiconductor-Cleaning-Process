package semiconductor.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Process1DTO {
	private int waferId;
	private int clean1;
	private int clean2;
	private int rinse1;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Process1DTO [waferId=");
		builder.append(waferId);
		builder.append(", clean1=");
		builder.append(clean1);
		builder.append(", clean2=");
		builder.append(clean2);
		builder.append(", rinse1=");
		builder.append(rinse1);
		builder.append("]");
		return builder.toString();
	}
}
