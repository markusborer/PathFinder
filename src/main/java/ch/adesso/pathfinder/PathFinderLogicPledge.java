package ch.adesso.pathfinder;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/*
Wenn Eingang und Ausgang mit der Aussenmauer verbunden sind, kann man mit der Hand-Regel auch den Weg durch einen nicht einfach zusammenhängenden Irrgarten finden.
Startet man jedoch im Inneren des Irrgartens, kann es passieren, dass man mit der Hand-Regel ewig an einer Wand entlang im Kreis läuft, die nicht mit dem Ausgang verbunden ist.
Der Pledge-Algorithmus (benannt nach Jon Pledge aus Exeter) löst dieses Problem (siehe Turtle Geometry: the computer as a medium for exploring mathematics, Abelson & diSessa, 1980).

Der Pledge-Algorithmus, konzipiert, um Hindernisse zu umrunden, benötigt eine zufällig gewählte Zielrichtung.
Trifft man auf ein Hindernis, legt man eine Hand auf das Hindernis und hält auf dem weiteren Weg den Kontakt aufrecht.
Dabei zählt man die Winkel, um die man sich beim Vorwärtsgehen von der Zielrichtung wegdreht oder auf die Zielrichtung zudreht.
Ist man wieder in Zielrichtung ausgerichtet und ist die Summe der gemachten Drehungen gleich Null, löst man die Hand vom Hindernis und geht wieder geradeaus in Zielrichtung.

Die Hand wird nur dann von der Wand des Irrgartens genommen, wenn beide Bedingungen erfüllt sind: Summe der gemachten Drehungen gleich Null und aktuelle Ausrichtung gleich Zielrichtung.
Dadurch vermeidet der Algorithmus, in Fallen zu tappen, die die Form des Grossbuchstaben G besitzen.
Angenommen, man tritt von rechts in das G ein und wendet sich beim Treffen auf die linke Wand nach links, dreht man sich um 360 Grad.
Würde der Algorithmus vorsehen, nun die Wand wieder zu verlassen, da die aktuelle Richtung wieder der Zielrichtung vom Anfang entspricht, so wäre man in einer Endlosschleife gefangen.
Denn verlässt man die rechte untere Seite des G und geht nach links, trifft man wieder auf die gekrümmte linke Seite des G und macht erneut eine vollständige Drehung.
Der Pledge-Algorithmus verlässt jedoch die rechte untere Seite des G nicht, da die Summe der gemachten Drehungen nicht Null, sondern 360 ist.
Stattdessen folgt man weiter der Wand, verlässt das Innere des G wieder und nimmt die Hand von der Wand, wenn man sich an der Unterseite des G's befindet und wieder nach links blickt.

Falls es sich um einen endlichen und fairen zweidimensionalen Irrgarten handelt, kann man mit dem Pledge-Algorithmus und einem Kompass von jedem Punkt des Irrgartens aus den Weg ins Freie finden.
Umgekehrt funktioniert der Algorithmus jedoch nicht. So ist es mit dem Pledge-Algorithmus im Allgemeinen nicht möglich, vom Eingang aus ein Ziel im Inneren des Irrgartens zu finden.
*/
public class PathFinderLogicPledge implements PathFinderLogic {

	private int rotation = 0;

	@Override
	public DIRECTIONS getNewDirection(Labyrinth labyrinth, Point position, DIRECTIONS oldDirection) {
		return null;
	}

	/**
	 * Used from unit-test
	 * @return rotation
	 */
	int getRotation() {
		return rotation;
	}

	/**
	 * Used from unit-test
	 * @param rotation rotation
	 */
	void setRotation(int rotation) {
		this.rotation = rotation;
	}

}
