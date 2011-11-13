package guessNumber;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class SysoutPhaseListener implements PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		//System.out.println("Nach Phase " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		//System.out.println("Vor Phase " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
